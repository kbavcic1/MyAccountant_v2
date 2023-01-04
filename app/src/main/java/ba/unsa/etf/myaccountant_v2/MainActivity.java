package ba.unsa.etf.myaccountant_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar_view);

        // Set a listener to switch to the day view when a specific date is selected
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Switch to the day view
                showDayView(year, month, dayOfMonth);
            }
        });

        // Set a listener to switch to the week view when the user scrolls to a different week
        calendarView.setOnScrollListener(new CalendarView.OnScrollListener() {
            @Override
            public void onScroll(CalendarView view, int year, int month, int dayOfMonth) {
                // Switch to the week view
                showWeekView(year, month, dayOfMonth);
            }
        });

        // Set a listener to switch to the month view when the user clicks the "Month" button
        Button monthButton = (Button) findViewById(R.id.month_button);
        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to the month view
                showMonthView();
            }
        });

        // Set a listener to switch to the year view when the user clicks the "Year" button
        Button yearButton = (Button) findViewById(R.id.year_button);
        yearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch to the year view
                showYearView();
            }
        });

    }


}