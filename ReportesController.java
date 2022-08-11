package reto4.controller;

import java.sql.SQLException;

import reto4.model.dao.ListaLideresDao;
import reto4.model.dao.ComprasPorProyectoDao;
import reto4.model.dao.ProyectosDao;
import reto4.model.vo.*;
import java.util.List;


public class ReportesController {
    private ProyectosDao proyectosDao;
    private ComprasPorProyectoDao comprasPorProyectoDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController(){
        proyectosDao = new ProyectosDao();
        comprasPorProyectoDao = new ComprasPorProyectoDao();
        listaLideresDao = new ListaLideresDao();
    }
    public List<ProyectosVo> listarProyectos() throws SQLException{
        return proyectosDao.listar();
    }
    public List<ComprasPorProyectoVo> listarCompras() throws SQLException{
        return  comprasPorProyectoDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLideresDao.listar();
    }
}

