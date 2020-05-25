package viewPackage.Affiliate;

import modelPackage.Affiliate;

import javax.swing.*;

public class AffiliateComboBoxModel extends DefaultComboBoxModel<Affiliate> {

    public AffiliateComboBoxModel(Affiliate[] items) {
        super(items);
    }

    @Override
    public Affiliate getSelectedItem() {
        Affiliate selectedAffiliate = (Affiliate) super.getSelectedItem();
        return selectedAffiliate;
    }
}
