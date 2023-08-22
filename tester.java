public class tester {
}

    private int month;
    private int day;
    private int year;
    private static final int daysPerMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31 };
    //constructor:confirm proper value for month and day given the year
    public Date1(int month, int day, int year) {

        this.month = validateMonth(month);
        this.year = validateYear(year);
        this.day = validateDay(day);
        System.out.printf("Date object constructor for date %s%n", this);

    }
    private int validateYear(int year) {

        if (year >= 1950 && year <= 2017)
            return year;
        else {
            System.out.printf("Invalid year (%d) set to 1950.", year); // validate
// year
            return 1950;
        }

    }

// validate if month in range

    private int validateMonth(int month) {
        if (month > 0 && month <= 12) //
            return month;
        else // month is invalid
        {
            System.out.printf("Invalid month (%d) set to 1.", month);
            return 1;
        }
    }
    // validate if day in range
    private int validateDay(int day) {
// System.out.println("days"+daysPerMonth[month]);
        if (day > 0 && day <= daysPerMonth[month]){
            return day;}
// validate for leap year if month is 2 and day is 29
        else if (month == 2 && day == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            return day;}
        else{
            System.out.printf("Invalid day (%d) set to 1.", day);
        }
        return 1;
    }
    private void nextDay() {
        if (day == 28 && month == 2 && year % 400 == 0) {
            day += 1;
        } else if (day >= daysPerMonth[month]) {
            nextMonth();
        } else
            day += 1;
    }
    private void nextMonth() {
        if (month == 12) {
            nextYear();
        } else {
            month =month+1;;
            day = 1;
        }
    }

    private void nextYear() {
        year=year+1;
        month = 1;
        day = 1;
    }

// return a String of the form month/day/year

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public static void main(String[] args) {
        Date1 d1 = new Date1(12, 4, 2017);
        for (int i = 0; i < 10; i++) {
            d1.nextDay();
            System.out.println(d1.toString());
        }
    } // end main()
}//end class Date1