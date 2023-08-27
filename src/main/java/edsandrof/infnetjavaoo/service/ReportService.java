package main.java.edsandrof.infnetjavaoo.service;

import main.java.edsandrof.infnetjavaoo.exceptions.FileException;
import main.java.edsandrof.infnetjavaoo.model.Vehicle;
import main.java.edsandrof.infnetjavaoo.model.VehicleSale;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportService {
    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';
    public static final String BODY_TAG = "BODY";
    public static final String HEAD_TAG = "HEAD";
    public static final String HTML_TAG = "HTML";
    public static final String TABLE_TAG = "TABLE";
    public static final String TR_TAG = "tr";
    public static final String TH_TAG = "th";
    public static final String TD_TAG = "td";

    public void writeReport(String path, String dealerName, VehicleSale[] sales) {
        StringBuilder sb = new StringBuilder();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("<html><body>");
            bw.write("<h1>" + dealerName + " - Sales Report</h1><hr>");
            bw.newLine();

            for (VehicleSale sale : sales) {
                if (sale == null) {
                    continue;
                }

                // table
                bw.write("<b>" + sale.getVehicleBuyer() + "</b>");
                bw.newLine();
                bw.write("</br><b>Purchase date:</b> " + sale.getPurchaseDate().toLocalDate());
                bw.newLine();
                bw.write("</br></br><table border='1' style='width: 25%;'>");
                bw.newLine();
                bw.write(getTableHeader());
                bw.newLine();
                for (Vehicle vehicle : sale.getVehicles()) {
                    sb.append(open(TR_TAG));
                    sb.append(open(TD_TAG)).append(vehicle.getId()).append(close(TD_TAG));
                    sb.append(open(TD_TAG)).append(vehicle.getBrand()).append(close(TD_TAG));
                    sb.append(open(TD_TAG)).append(vehicle.getYear()).append(close(TD_TAG));
                    sb.append(open(TD_TAG)).append(vehicle.getFuelType().name()).append(close(TD_TAG));
                    sb.append(open(TD_TAG)).append(vehicle.getPrice()).append(close(TD_TAG));
                    sb.append(close(TR_TAG));
                    bw.write(sb.toString());
                    bw.newLine();
                    sb.setLength(0);    // clean string builder
                }
                bw.write("</table>");
                bw.newLine();
                bw.write("</br><b>Total Cost:</b> " + sale.getTotalCost());
                bw.write("</br></br>");
                bw.newLine();
            }

            // --
            bw.newLine();
            bw.write("</body></html>");

        } catch (IOException e) {
            throw new FileException("Error in file writer: " + e.getMessage());
        }
    }

    private String open(String tag) {
        return getTag(tag, false);
    }

    private String close(String tag) {
        return getTag(tag, true);
    }

    private String getTableHeader() {
        return open(TR_TAG) +
                open(TH_TAG) + "#" + close(TH_TAG) +
                open(TH_TAG) + "Vehicle brand" + close(TH_TAG) +
                open(TH_TAG) + "Year" + close(TH_TAG) +
                open(TH_TAG) + "Fuel Type" + close(TH_TAG) +
                open(TH_TAG) + "Price" + close(TH_TAG) +
                close(TR_TAG);
    }

    private String getTag(String tag, boolean closingTag) {
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_TAG);
        if (closingTag) {
            sb.append("/");
        }
        sb.append(tag);
        sb.append(CLOSE_TAG);

        return sb.toString();
    }
}
