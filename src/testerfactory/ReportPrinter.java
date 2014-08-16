/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testerfactory;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Reaper
 */
public class ReportPrinter {
    
    public ReportPrinter(String pageTitle,String cabID, JTable jTable1) throws JRException {
        
        try {
            String reportSource = "C:\\Users\\Reaper\\Documents\\NetBeansProjects\\TesterFactory\\build\\classes\\testerfactory\\cabReport.jrxml";            
            Map<String, Object> params = new HashMap<String, Object>();            
            
            params.put("cabID", cabID);
            params.put("pageTitle", pageTitle);
            
            params.put("title_0", jTable1.getColumnName(0));
            params.put("title_1", jTable1.getColumnName(1));
            params.put("title_2", jTable1.getColumnName(2));
            params.put("title_3", jTable1.getColumnName(3));
                        
            DefaultTableModel dModel=(DefaultTableModel)jTable1.getModel();
            JRTableModelDataSource dataSource = new JRTableModelDataSource(dModel);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);      
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();
        }
    }
}
