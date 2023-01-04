package ba.unsa.etf.myaccountant_v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.List;

public class EventCalendarView extends CalendarView {
    private List<CalendarEvent> events;

    public EventCalendarView(Context context) {
        super(context);
    }

    public EventCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EventCalendarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Get the width and height of the calendar
        int width = getWidth();
        int height = getHeight();

        // Get the current month and year
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getDate());
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // Calculate the number of rows and columns in the calendar
        int rows = 6;
        int columns = 7;

        // Calculate the size of each cell
        int cellWidth = width / columns;
        int cellHeight = height / rows;

        // Draw the events
        if (events != null) {
            for (CalendarEvent event : events) {
                Calendar startTime = event.getStartTime();
                if (startTime.get(Calendar.YEAR) == year && startTime.get(Calendar.MONTH) == month) {
                    // Calculate the row and column of the event
                    int dayOfMonth = startTime.get(Calendar.DAY_OF_MONTH);
                    int row = (dayOfMonth - 1) / columns;
                    int column = (dayOfMonth - 1) % columns;

                    // Calculate the x and y coordinates of the event
                    int x = column * cellWidth;
                    int y = row * cellHeight;

                    // Draw the event at the calculated coordinates
                    // ...
                    // Set the paint options for the event
                    Paint paint = new Paint();
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.FILL);

// Calculate the size and position of the event rectangle
                    int eventWidth = cellWidth / 2;
                    int eventHeight = cellHeight / 2;
                    int eventX = x + cellWidth / 4;
                    int eventY = y + cellHeight / 4;

// Draw the event rectangle on the calendar
                    canvas.drawRect(eventX, eventY, eventX + eventWidth, eventY + eventHeight, paint);

// Set the paint options for the event title text
                    paint.setColor(Color.WHITE);
                    paint.setTextSize(16f);

// Measure the event title text
                    Rect bounds = new Rect();
                    paint.getTextBounds(event.getTitle(), 0, event.getTitle().length(), bounds);

// Calculate the position of the event title text
                    int textX = eventX + (eventWidth - bounds.width()) / 2;
                    int textY = eventY + (eventHeight + bounds.height()) / 2;

// Draw the event title text on the calendar
                    canvas.drawText(event.getTitle(), textX, textY, paint);
                }
            }
        }
    }
}
