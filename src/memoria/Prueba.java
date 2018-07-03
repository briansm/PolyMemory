
package memoria;

import java.util.ArrayList;
import javax.swing.JComboBox;


public class Prueba {
    ArrayList<Lexemas>listLex;
    ArrayList<Niveles>listNi;
    ArrayList<Idiomas>listid;
    
    public void Prueba(ArrayList ll,JComboBox cbUsuarios){
        listLex=ll;
        
        for(int x=0;x<listLex.size();x++) {
                cbUsuarios.addItem(((Lexemas)listLex.get(x)).getTok());
            }
    }
    
    public void Prueba2(ArrayList ll,JComboBox cbUsuarios){
        listNi=ll;
        
        for(int x=0;x<listNi.size();x++) {
                cbUsuarios.addItem(((Niveles)listNi.get(x)).getN());
            }
    }
    
    public void Prueba3(ArrayList ll,JComboBox cbUsuarios){
        listid=ll;
        
        for(int x=0;x<listid.size();x++) {
                cbUsuarios.addItem(((Idiomas)listid.get(x)).getid());
            }
    }
}
