/**
 * Created by dumin on 8/6/2017.
 */
public class Procedure {

    private int procedureId;
    private String procedureType;
    private String description;
    private String toothInvolved;
    private String totalCharge;
    private String amountPaid;
    private String insuranceCoverAmount;



    public  Procedure(){

        procedureId=0;
        procedureType="";
        description="";
        toothInvolved="";
        totalCharge="";
        amountPaid="";
        insuranceCoverAmount="";
    }


    public Procedure(int procedureId, String procedureType, String description,String toothInvolved,String totalCharge, String amountPaid,String insuranceCoverAmount){

     this.procedureId=procedureId;
        this.procedureType=procedureType;
        this.description=description;
        this.toothInvolved=toothInvolved;
        this.totalCharge=totalCharge;
        this.amountPaid=amountPaid;
        this.insuranceCoverAmount=insuranceCoverAmount;



    }


    public void setProcedureId(int procedureId){

        this.procedureId=procedureId;

    }
    public void setProcedureType(String procedureType){

        this.procedureType=procedureType;

    }
    public void setDescription(String description){

        this.description=description;

    }
    public void setToothInvolved(String toothInvolved){

        this.toothInvolved=toothInvolved;

    }
    public void setTotalCharge(String totalCharge){

        this.totalCharge=totalCharge;

    }
    public void setAmountPaid(String amountPaid){

        this.amountPaid=amountPaid;

    } public void setInsuranceCoverAmount(String insuranceCoverAmount){

        this.insuranceCoverAmount=insuranceCoverAmount;

    }



    public int getProcedureId(){

        return procedureId;
    }

    public String getProcedureType(){

        return procedureType;
    }

    public String  getDescription(){

        return description;
    }
    public String getToothInvolved(){

        return toothInvolved;
    }

    public String  getTotalCharge(){

        return totalCharge;
    }

    public String getAmountPaid(){

        return amountPaid;
    }

    public String getInsuranceCoverAmount(){

        return insuranceCoverAmount;
    }


}


