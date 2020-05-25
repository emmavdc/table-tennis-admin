package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.AffiliateRanking;
import modelPackage.Ranking;

import java.sql.*;
import java.util.ArrayList;

public class RankingDBAccess implements  RankingDataAccess{

    @Override
    public ArrayList<Ranking> getAllRankings() throws RankingAccessException {

        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "select * from ranking";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Ranking>allRankings = new ArrayList<>();

            while(data.next()){

                allRankings.add(mapRankingRowToModel(data));

            }
            return allRankings;

        }
        catch(SQLException e){
            throw new RankingAccessException();
        }

    }

    private Ranking mapRankingRowToModel(ResultSet data) throws SQLException{

        Ranking ranking;
        ranking = new Ranking(data.getInt("ranking_id"), data.getString("name"));
        return ranking;
    }

    @Override
    public ArrayList<AffiliateRanking> getRankingsByAffiliateId(int affiliateId) throws RankingAccessException{
        try{

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "SELECT ranking.name, affiliate_ranking.gender, affiliate_ranking.season, affiliate_ranking.affiliate_ranking_id, affiliate_ranking.affiliate_id, \n" +
                    "affiliate_ranking.ranking_id \n" +
                    "FROM affiliate_ranking JOIN ranking ON \n" +
                    "ranking.ranking_id = affiliate_ranking.ranking_id\n" +
                    "JOIN affiliate \n" +
                    "ON affiliate.affiliate_id = affiliate_ranking.affiliate_id\n" +
                    "WHERE affiliate.affiliate_id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateId);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<AffiliateRanking>allRankings = new ArrayList<>();

            while(data.next()){

                allRankings.add(mapAffiliateRankingRowToModel(data));

            }
            return allRankings;

        }
        catch(SQLException e){
            throw new RankingAccessException();
        }
    }

    private AffiliateRanking mapAffiliateRankingRowToModel(ResultSet data) throws SQLException{

        AffiliateRanking affiliateRanking;
        affiliateRanking = new AffiliateRanking(data.getInt("affiliate_ranking_id"), data.getString("name"),
                data.getString("gender"), data.getInt("season"),
                data.getInt("affiliate_id"), data.getInt("ranking_id"));
        return affiliateRanking;
    }

    @Override
    public void insertAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException {

        try{
            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "insert into affiliate_ranking(season,affiliate_id, ranking_id, gender) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setInt(1, affiliateRanking.getSeason());
            preparedStatement.setInt(2, affiliateRanking.getAffiliateID());
            preparedStatement.setInt(3, affiliateRanking.getRankingID());
            preparedStatement.setString(4, affiliateRanking.getGender());

            preparedStatement.executeUpdate();

        }
        catch(SQLException e){
            throw new RankingAccessException();
        }
    }

    @Override
    public void updateAffiliateRanking(AffiliateRanking affiliateRanking) throws RankingAccessException {

        try {

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction = "update affiliate_ranking set ranking_id = ?" +
                    " where affiliate_ranking_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateRanking.getRankingID());
            preparedStatement.setInt(2, affiliateRanking.getAffiliateRankingID());

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RankingAccessException();
        }
    }

    @Override
    public void deleteAffiliateRanking(int affiliateRankingId) throws RankingAccessException {

        try {

            Connection connection = SingletonConnection.getInstance();

            String sqlInstruction ="delete from affiliate_ranking where affiliate_ranking_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, affiliateRankingId);

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RankingAccessException();
        }
    }












}
