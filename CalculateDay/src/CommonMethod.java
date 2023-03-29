import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import  java.util.Date;

public class CommonMethod {
    public long totalDayFromDateToDate (String valStartDate, String valEnđate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FORMAT_DATE_DD_MM_YYYY);
            String formatStartDate = formatStringDateDDMMYYYY(valStartDate);
            String formatEndDate = formatStringDateDDMMYYYY(valEnđate);
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Date startDate = dateFormat.parse(formatStartDate);
            Date endDate = dateFormat.parse(formatEndDate);
            c1.setTime(startDate);
            c2.setTime(endDate);
            long totalDays = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
            return totalDays;
        } catch (ParseException e) {
            System.out.println("error " + e.getMessage());
            return 0;
        }
    }

    public String getEndDate (String inputDate, int numbMonth) {
        String formatStartDate = formatStringDateDDMMYYYY(inputDate);
        try {
            SimpleDateFormat format = new SimpleDateFormat(Constant.FORMAT_DATE_DD_MM_YYYY);
            Date startDate = format.parse(formatStartDate);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(startDate);
            c1.roll(Calendar.MONTH, numbMonth);
            String result =  formatStringDateYYYYMMDD(format.format(c1.getTime()));
            return result;
        } catch (ParseException e) {
           return null;
        }
    }

    private String formatStringDateDDMMYYYY (String valInput) {
        String year = valInput.substring(0, 4);
        String month = valInput.substring(4, 6);
        String day = valInput.substring(6);
        String result = day + "/" + month + "/" + year;
        return result;
    }

    private String formatStringDateYYYYMMDD (String valInput) {
        String[] arrData = valInput.split("/");
        String day = arrData[0];
        String month = arrData[1];
        String year = arrData[2];
        String result = year + month + day;
        return result;
    }
}
