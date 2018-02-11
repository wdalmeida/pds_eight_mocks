package service.rest.metier;

/**
 * Created by Vyach on 04/02/2018.
 */
public enum CodeCompany {

    LVMH_MOET_VUITTON ("MC"),
    KERLING ("KER"),
    MICHELIN_N( "ML");

    private String codeCompany;

    CodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String toString() {
        return codeCompany;
    }

    public static boolean contains(String codeCompany) {

        for(CodeCompany code : CodeCompany.values()) {

            if (code.equals(codeCompany)) {
                return true;
            }
        }

        return false;
    }
}
