package EjercicioD;

import java.util.ArrayList;
import java.util.List;

public class Barrio {
    long id;
    String nombre;
    String empresaConstructora;

    List<Vivienda> viviendas = new ArrayList<>();

    public Barrio() {
    }

    public Barrio(long id, String nombre, String empresaConstructora) {
        this.id = id;
        this.nombre = nombre;
        this.empresaConstructora = empresaConstructora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaConstructora() {
        return empresaConstructora;
    }

    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }

    public List<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(List<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }

    public void addVivienda(Vivienda v) {
        viviendas.add(v);
    }

    public double getSuperficieTotalTerreno(){
        double  total=0;
        for(Vivienda a:viviendas){
            total+=a.getSuperficieTerreno();
        }
        return total;
    }
    public double getSuperficieTotalCubierta() throws Exception {
        double total=0;
        for (Vivienda a:viviendas){
            total +=a.getMetrosCuadradosCubiertos();
        }
        return total;


    }

}
