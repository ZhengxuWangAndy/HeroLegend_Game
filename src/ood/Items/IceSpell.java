package ood.Items;/*
 * Use for new a Ice spell item with it's own category. Extends from ood.Spells.
 * */

import ood.Items.Spells;

public class IceSpell extends Spells implements ItemMethods {
    public IceSpell(String filePath) {
        super(filePath);
    }

    @Override
    public void choose(int serial) {
        super.choose(serial);
        this.propertiesMap.put("category","IceSpell");
    }
}

