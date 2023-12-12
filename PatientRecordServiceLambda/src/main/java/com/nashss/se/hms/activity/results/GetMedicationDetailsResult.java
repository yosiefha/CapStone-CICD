package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.MedicationModel;

import java.util.List;

public class GetMedicationDetailsResult {

    private final List<MedicationModel> medicationModelList;

    public GetMedicationDetailsResult(List<MedicationModel> medicationModelList) {
        this.medicationModelList = medicationModelList;
    }

    public List<MedicationModel> getMedicationModelList() {
        return medicationModelList;
    }

    @Override
    public String toString() {
        return "GetMedicationDetailsResult{" +
                "medicationModelList=" + medicationModelList +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private List<MedicationModel> medicationModelList;
        public  Builder withMedicationList(List<MedicationModel> medicationModelList){
            this.medicationModelList = medicationModelList;
            return this;
        }
        public GetMedicationDetailsResult build(){
            return  new GetMedicationDetailsResult(medicationModelList);
        }
    }
}
