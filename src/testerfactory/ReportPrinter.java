/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testerfactory;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Reaper
 */
public class ReportPrinter {

    public ReportPrinter(Cab cab) throws JRException {
        //System.out.println("Sucess: "+cab.getCabID());

        try {
            String reportSource = "C:\\Users\\Reaper\\Documents\\NetBeansProjects\\TesterFactory\\build\\classes\\testerfactory\\cabReport.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            
            
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();
        }
    }
}
