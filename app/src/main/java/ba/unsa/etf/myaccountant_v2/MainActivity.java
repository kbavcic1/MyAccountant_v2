package ba.unsa.etf.myaccountant_v2;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EventCalendarView calendarView;
    List<CalendarEvent> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (EventCalendarView) findViewById(R.id.calendarView);

        // Initialize the list of events
        events = new ArrayList<>();

        // Add some sample events
        Calendar startTime1 = Calendar.getInstance();
        startTime1.set(Calendar.HOUR_OF_DAY, 9);
        startTime1.set(Calendar.MINUTE, 0);
        Calendar endTime1 = Calendar.getInstance();
        endTime1.set(Calendar.HOUR_OF_DAY, 10);
        endTime1.set(Calendar.MINUTE, 0);
        events.add(new CalendarEvent("Meeting with Bob", startTime1, endTime1));

        Calendar startTime2 = Calendar.getInstance();
        startTime2.set(Calendar.HOUR_OF_DAY, 14);
        startTime2.set(Calendar.MINUTE, 0);
        Calendar endTime2 = Calendar.getInstance();
        endTime2.set(Calendar.HOUR_OF_DAY, 15);
        endTime2.set(Calendar.MINUTE, 0);
        events.add(new CalendarEvent("Lunch with Alice", startTime2, endTime2));

        calendarView.setEvents(events);
        // Set an OnDateChangeListener to display the list of events for the selected date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                List<String> eventTitles = new ArrayList<>();
                for (CalendarEvent event : events) {
                    Calendar startTime = event.getStartTime();
                    if (startTime.get(Calendar.YEAR) == year && startTime.get(Calendar.MONTH) == month && startTime.get(Calendar.DAY_OF_MONTH) == dayOfMonth) {
                        eventTitles.add(event.getTitle());
                    }
                }
                Toast.makeText(getApplicationContext(), eventTitles.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

// CalendarEvent class to represent events in the calendar
class CalendarEvent {
    private String title;
    private Calendar startTime;
    private Calendar endTime;

    public CalendarEvent(String title, Calendar startTime, Calendar endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }
}
