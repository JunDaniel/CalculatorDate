public class CalculateDate {
    public static void main(String[] args) {
        String startDate = "20230215";
        String endDate = "20230218";
        CommonMethod cmTh = new CommonMethod();
        long totalDay = cmTh.totalDayFromDateToDate(startDate, endDate);
        int numbMonth = 1;
        String getEndDate = cmTh.getEndDate(startDate, numbMonth);
        System.out.println("Total days between start date " + startDate + " and end date " + endDate + " is " + totalDay + " day(s)");
        System.out.println("After " + numbMonth + " month of date " + startDate + " is " + getEndDate);
    }
}
