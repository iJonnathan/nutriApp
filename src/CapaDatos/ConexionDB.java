/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;
import Enumeraciones.EstadoNutricional;
import Clases.DiarioDietetico;
import Clases.Fecha;
import Enumeraciones.Sexo;
import Clases.Registro;
import Enumeraciones.TipoActividadFisica;
import Clases.Usuario;
import CapaLogica.ManejoDeArchivos;
import CapaLogica.ManejoDeFecha;
import static CapaPresentacion.NutriAppMain.usuario;
import java.sql.*;
import java.util.*;
import java.util.Stack;
import javax.swing.JOptionPane;


public class ConexionDB {

     Connection conexion = null;
     Statement st = null;
            
    public ConexionDB(String ruta) {
        try{
            conexion = DriverManager.getConnection(ruta);
            st = conexion.createStatement();
            System.out.println("conexion exitosa, direccion: "+ruta);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"conexion erroneasaaa "+e);
        }
    }

    
    public Connection getConnection(){
        return conexion;
    }
    public void insertarUsuario(){
        try {
            PreparedStatement st;
            st=conexion.prepareStatement("insert into tablaUsuarios(nombre,cuenta,pass,dia,mes,anio,edad,sexo,"
                                   +"peso,talla,tipoActFis,tiempoActFis,reqEnergetico,estadoActual,url) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            st.setString(1, usuario.getNombre());
            st.setString(2,usuario.getId());
            st.setString(3, usuario.getPass());
            st.setString(4, usuario.getFecha().getDia());
            st.setString(5, usuario.getFecha().getMes());
            st.setString(6, usuario.getFecha().getAnio());
            st.setInt(7, usuario.getEdad());
            st.setString(8, usuario.getSexo().toString());
            st.setDouble(9, usuario.getPeso());
            st.setDouble(10, usuario.getTalla());
            st.setString(11, usuario.getTipoActividadFisica().toString());
            st.setInt(12, usuario.getTiempoActvFisica());
            st.setInt(13, usuario.getRequerimientoEnergetico());
            st.setString(14, usuario.getEstadoNutricionalActual().toString());
            st.setString(15, usuario.getUrl());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"No se pudo insertar el registro : \n"+e);
       }
    }
    
    public Usuario buscarUsuario(String cuentaUsuario, String pass){
        try {
            PreparedStatement pst;
            pst = conexion.prepareStatement("SELECT nombre,cuenta,pass,dia,mes,anio,edad,sexo,"
                                                  + "peso,talla,tipoActFis,tiempoActFis,reqEnergetico,estadoActual,url FROM tablaUsuarios WHERE cuenta='"+cuentaUsuario+"'");
            
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.next()){
                
                Usuario nuevo=new Usuario();
                Fecha fecha = new Fecha(rs.getString("dia"),rs.getString("mes"),rs.getString("anio"));
                nuevo.setNombre(rs.getString("nombre"));
                nuevo.setId(rs.getString("cuenta"));
                nuevo.setPass(rs.getString("pass"));
                nuevo.setFecha(fecha);
                nuevo.setEdad(rs.getInt("edad"));
                nuevo.setSexo(retornarSexo(rs.getString("sexo")));
                nuevo.setPeso(rs.getDouble("peso"));
                nuevo.setTalla(rs.getDouble("talla"));
                nuevo.setTipoActividadFisica(retornActFis(rs.getString("tipoActFis")));
                nuevo.setTiempoActvFisica(rs.getInt("tiempoActFis"));
                nuevo.setRequerimientoEnergetico(rs.getInt("reqEnergetico"));
                nuevo.setEstadoNutricionalActual(retornarEstado(rs.getString("estadoActual")));
                nuevo.setUrl(rs.getString("url"));
                
                if (pass.equals(nuevo.getPass())){  // si la contraseña es la misma
                     return nuevo;
                }
                pst.close();
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta"+e );
        } return null;
    }

     
    public void registrarDiario(Usuario usuario, Registro registro,String medida, int cantidad){
        try {
            
            Calendar calendario = new GregorianCalendar();
            PreparedStatement st;
            st=conexion.prepareStatement("insert into tablaDiarios(cuenta,d,mes,anio,fecha,dia,hora,cantidad,"
                                                            + "medida,alimento,numCalorias) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
          
            st.setString(1, usuario.getId());
            System.out.println("id "+usuario.getId());
            st.setInt(2,calendario.get(Calendar.DAY_OF_MONTH) );
            st.setInt(3, calendario.get(Calendar.MONTH)+1);
            st.setInt(4, calendario.get(Calendar.YEAR));
            st.setString(5, ManejoDeFecha.calcularFechaActual());
            st.setString(6, ManejoDeFecha.calcularDiaActual());
            st.setString(7, registro.getTiempo());
            st.setInt(8, cantidad);
            st.setString(9, medida);
            st.setString(10, registro.getAlimento());
            st.setInt(11, registro.getCalorias());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"No se pudo insertar el registro : \n"+e);
       }
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public Statement getSt() {
        return st;
    }


    private Sexo retornarSexo(String sexo) {
        Object s = Sexo.MASCULINO;
        if (sexo.equals( Sexo.FEMENINO.toString()))
            s = Sexo.FEMENINO;
        else if (sexo.equals( Sexo.MASCULINO.toString()))
            s = Sexo.MASCULINO;
        return (Sexo)s;
    }

    private TipoActividadFisica retornActFis(String tipo) {
        Object s = TipoActividadFisica.INTENSA;
        if (tipo.equals( TipoActividadFisica.INTENSA.toString()))
            s = TipoActividadFisica.INTENSA;
        else if (tipo.equals( TipoActividadFisica.LIGERA.toString()))
            s = TipoActividadFisica.LIGERA;
        else if (tipo.equals( TipoActividadFisica.MODERADA.toString()))
            s = TipoActividadFisica.MODERADA;
        return (TipoActividadFisica)s;}

    private EstadoNutricional retornarEstado(String tipo) {
       Object s = EstadoNutricional.BAJO_PESO;
        if (tipo.equals(EstadoNutricional.BAJO_PESO.toString()))
            s = EstadoNutricional.BAJO_PESO;
        else if (tipo.equals(EstadoNutricional.NORMAL.toString()))
            s = EstadoNutricional.NORMAL;
        else if (tipo.equals(EstadoNutricional.OBESIDAD_GRADO_1.toString()))
            s = EstadoNutricional.OBESIDAD_GRADO_1;
        else if (tipo.equals(EstadoNutricional.OBESIDAD_GRADO_2.toString()))
            s = EstadoNutricional.OBESIDAD_GRADO_2;
        else if (tipo.equals(EstadoNutricional.OBESIDAD_GRADO_3.toString()))
            s = EstadoNutricional.OBESIDAD_GRADO_3;
        else if (tipo.equals(EstadoNutricional.SOBREPESO.toString()))
            s = EstadoNutricional.SOBREPESO;
        return (EstadoNutricional)s;
    }

   
    public Stack<DiarioDietetico> recuperarDiarios() {
        
         try {
            ResultSet rs;
            Statement sql = conexion.createStatement();
            rs= sql.executeQuery("select * from tablaDiarios");
            	
            boolean r = rs.next();	
            
            List<Registro> registros = new LinkedList<Registro>();
            while(r )
            {                   
                    String fecha = rs.getString("fecha");
                    String hora = rs.getString("hora");
                    String porcion = String.valueOf(rs.getInt("cantidad"))+" "+rs.getString("medida");
                    Registro registro = new Registro(porcion, rs.getString("alimento"), rs.getInt("numCalorias"),hora);
                    
                    registro.setFecha(fecha);
                    registro.setDd(rs.getInt("d"));
                    registro.setMm(rs.getInt("mes"));
                    registro.setAa(rs.getInt("anio"));
                    registro.setDia(rs.getString("dia"));
                    registros.add(registro);
                    r= rs.next();
            }
            rs.close();
            sql.close();
             
            Stack<DiarioDietetico>  diarios = new Stack<>();
            int i =0;
             
             while (i < registros.size()){
                 
                    String fecha = registros.get(i).getFecha();
                    DiarioDietetico diario = new DiarioDietetico(fecha, registros.get(i).getDia());
                    diario.setDd(registros.get(i).getDd());
                    diario.setMm(registros.get(i).getMm());
                    diario.setAa(registros.get(i).getAa());
                    introducirRegistroAlDiario(diario,registros.get(i));
                    i++;
                   if ( i< registros.size()  ){    
                       boolean pase = true;
                        while ( pase==true && i < registros.size() ){
                            
                            String auxFecha = registros.get(i).getFecha();
                            
                            if (auxFecha.equals(fecha)){
                                introducirRegistroAlDiario(diario,registros.get(i));
                                i++;
                            }
                            else
                                pase = false;
                        }
                    }
                    diarios.add(diario);
            }
             return diarios;
        } 
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los diarios ..."+e );
        }     
         return null;
    }

    private void introducirRegistroAlDiario(DiarioDietetico diario, Registro registro) {
        String hora = registro.getTiempo();
        
        switch (hora) {
            case "Desayuno":
                diario.desayuno.agregarRegistro(registro);
                break;
            case "Almuerzo":
                diario.almuerzo.agregarRegistro(registro);
                break;
            case "Cena":
                diario.cena.agregarRegistro(registro);
                break;
            case "Refrigerio":
                diario.refrigerio.agregarRegistro(registro);
                break;
            default:
                break;                
        }
        diario.numeroCalorias += registro.getCalorias();
    }

    public String buscarAlimento(String alimento) {
        try {
            PreparedStatement pst;
            pst = conexion.prepareStatement("SELECT nombre,descripcion,caloriasPorUnidad,caloriasPor100gramos FROM tablaAlimentos WHERE nombre='"+alimento+"'");
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.next()){
                String descripcion = rs.getString("descripcion");
                pst.close();
                rs.close();
                return descripcion;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta"+e );
        } return "";
    }
    
    public int buscarNumeroCalorias(String alimento, String medida) {
        try {
            PreparedStatement pst;
            pst = conexion.prepareStatement("SELECT nombre,descripcion,caloriasPorUnidad,caloriasPor100gramos FROM tablaAlimentos WHERE nombre='"+alimento+"'");
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.next()){
                int calorias;
                if (medida.equals("unidad"))
                    calorias = rs.getInt("caloriasPorUnidad");
                else
                    calorias = rs.getInt("caloriasPor100gramos");
                
                
                pst.close();
                rs.close();
                return calorias;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta"+e );
        } return 0;
    }

    public void modificarDataBaseUsuario(String cuentaUsuario) {
        
        try {
            PreparedStatement pst;
            pst = conexion.prepareStatement("SELECT nombre,cuenta,pass,dia,mes,anio,edad,sexo,"
                                                  + "peso,talla,tipoActFis,tiempoActFis,reqEnergetico,estadoActual,url FROM tablaUsuarios WHERE cuenta='"+cuentaUsuario+"'");
            
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.next()){
                
                Usuario nuevo=new Usuario();
                Fecha fecha = new Fecha(rs.getString("dia"),rs.getString("mes"),rs.getString("anio"));
                nuevo.setNombre(rs.getString("nombre"));
                nuevo.setId(rs.getString("cuenta"));
                nuevo.setPass(rs.getString("pass"));
                nuevo.setFecha(fecha);
                nuevo.setEdad(rs.getInt("edad"));
                nuevo.setSexo(retornarSexo(rs.getString("sexo")));
                nuevo.setPeso(rs.getDouble("peso"));
                nuevo.setTalla(rs.getDouble("talla"));
                nuevo.setTipoActividadFisica(retornActFis(rs.getString("tipoActFis")));
                nuevo.setTiempoActvFisica(rs.getInt("tiempoActFis"));
                nuevo.setRequerimientoEnergetico(rs.getInt("reqEnergetico"));
                nuevo.setEstadoNutricionalActual(retornarEstado(rs.getString("estadoActual")));
                nuevo.setUrl(rs.getString("url"));
               
               
                pst.close();
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta"+e );
        } 
        
    }

    public boolean verificarMedida(String alimento) {
        try {
            PreparedStatement pst;
            pst = conexion.prepareStatement("SELECT nombre,descripcion,caloriasPorUnidad,caloriasPor100gramos FROM tablaAlimentos WHERE nombre='"+alimento+"'");
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.next()){
                
                
                int calorias = rs.getInt("caloriasPorUnidad");
                if (calorias!=0)    return true;
                else 
                    return false;
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer la consulta"+e );
        } return false;
    }
         
   public  void crearDBUsuario() {
        String id = usuario.getId();
        String extc = ".accdb";
        String ruta = System.getProperty("user.dir") +"\\src\\BaseDatos\\Diarios\\Diario de ";
        String destino = ruta+id+extc;
        usuario.setUrl(destino);
        String origen= System.getProperty("user.dir")+"\\src\\BaseDatos\\plantillaDeDiarios.accdb";
        
        ManejoDeArchivos.duplicarArchivo(origen, destino);
    
    }
}       
    
    
    
