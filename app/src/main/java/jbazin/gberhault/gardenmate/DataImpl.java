////////////////////////////////////////////////////////////////////////////////
// Copyright (c) Guillaume Berhault and Jerome Bazin since 2017.
////////////////////////////////////////////////////////////////////////////////

package jbazin.gberhault.gardenmate;


class DataImpl implements Data {
    @Override
    public String[] getPlantList(PlantType type) {
        return new String[]{"pepper", "tomato"};
    }
}
