package PaqI04;

import java.util.Scanner;

public class Hub{
    //ATTRIBUTES:
    private Container[][] v;


    //CONSTRUCTOR:
    public Hub(){
        this.v = new Container[10][12]; //filas[10] y columnas[12]
        //Filas: m.length; //10
        //Columnas de la fila 3: m[3].length; //12
        //Columnas de la fila i: m[i].length; //12
    }


    //GETTERS & SETTERS:
    public Container[][] getV(){
        return v;
    }
    public void setV(Container[][] v){
        if(v != null) this.v = v;
    }


    //TO STRING:
    public String toString(){
        String s = new String();
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                if(v[i][j] == null) s += "[N]";
                else s +="["+ v[i][j].getId()+"]";
            }
            s += "\n";
        }
        s += "\n";
        return s;
    }


    //METHODS:
    public Container desapilar(int colum){
        if(colum < 0 || colum >= v[0].length) return null;
        for(int i = 0; i < v.length; i++){
            if(v[i][colum] != null){
                Container aux = v[i][colum];
                v[i][colum] = null; //BORRADO
                return aux; //Devuelve el valor
            }
        }
        return null;
    }
    public void apilar(Container c){
        if (c != null){
            int p = c.getPriority();
            if(p == 1 || p == 2){
                int colum = p-1;
                for(int i = v.length-1; i >= 0; i--){
                    if (v[i][colum] == null){
                        v[i][colum] = c;
                        return;
                    }
                }
            }

            else{
                for(int j = 2; j < v[0].length; j++){
                    for(int i = v.length-1; i >= 0; i--){
                        if(v[i][j] == null){
                            v[i][j] = c;
                            return;
                        }
                    }
                }
            }

        }
    }
    public void display(){
        boolean found = false;
        Scanner scan = new Scanner (System.in);
        System.out.println("Please indicate the container's identifier: ");
        int id = scan.nextInt();

        for (int i = 0; i < v[0].length; i++){
            for (int j = 0; j < v.length; j++){
                if(v[j][i] != null)
                    if (id == v[j][i].id){
                        System.out.println(v[j][i]);
                        found = true;
                    }
            }
        }
        if (found == false) System.out.println("The container is not in the hub!");
    }

    public int contC (String x){
        int cont = 0;

        for (int i = 0; i < v[0].length; i++) {
            for (int j = 0; j < v.length; j++) {
                if(v[j][i] != null)
                    if(v[j][i].country.equals(x)) cont ++;
            }
        } System.out.println("The number of containers from " + x + " is " + cont );

        return cont;
    }
}
