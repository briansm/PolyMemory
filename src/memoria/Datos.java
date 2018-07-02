
package memoria;


public class Datos {
    
    //-------Declaracion de variables--------
        int numero;
        int fila = 1;
        int columna;

        String lexi;
        String error;
        String token;
        String Terror = "Error Lexico, TOken No reconocido";
        String Serror = "Error Sintactico";
        String desc;
        String terminal;
    
    //------------------Construcctores---------------------
    public Datos(int num,String lexe,String tokn,int f,int c){
        this.numero = num;
        this.lexi = lexe;
        this.token = tokn;
        this.fila = f;
        this.columna = c;
    }
    public Datos(int num,String error,int f,int c){
        this.numero = num;
        this.error = error;
        this.fila = f;
        this.columna = c;
    }
    
     public Datos(String terminal,int f,int c,String desc){
        this.terminal = terminal;
        this.fila = f;
        this.columna = c;
        this.desc=desc;
    }
    
    
    //-------------------Getters y setter------------------------------------------
            public int getNumero() {
                return numero;   
            }
            public void setNumero(int nume) {
                this.numero = nume;
            }

            public int getFila()
            {
                return fila;
            }
            public void setFila(int fila)
            {
                this.fila = fila;
            }

            public int getColum()
            {
                return columna;
            }
            public void setColum(int colum)
            {
                this.columna = colum;
            }

            public String getLexi()
            {
                return lexi;
            }
            public void setLexi(String lexi)
            {
                this.lexi = lexi;
            }

            public String getToken()
            {
                return token;
            }
            public void setToken(String  token)
            {
                this.token = token;
            }

            public String getError()
            {
                return error;
            }
            public void setError(String error)
            {
                this.error = error;
            }

            public String getTerror()
            {
                return Terror;
            }
            public void setTerror(String terror)
            {
                this.Terror = terror;
            }
            
            public String getSerror()
            {
                return Serror;
            }
            public void setSerror(String Serror)
            {
                this.Serror = Serror;
            }
            
            public String getDesc() {
                return desc;   
            }
            public void setDesc(String  desc) {
                this.desc = desc;
            }
            public String getTerm() {
                return terminal;   
            }
            public void setTerm(String  terminal) {
                this.terminal = terminal;
            }
}
