
package com.mycompany.main;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventOperations {
    private Connection connection;

    public EventOperations() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }
    public void addEvent(Event event) {
        String query = "INSERT INTO events (title, description, category_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, event.getTitle());
            stmt.setString(2, event.getDescription());
            stmt.setInt(3, event.getCategoryId());
            stmt.executeUpdate();
            System.out.println("Event added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                events.add(new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("category_id"),
                        rs.getBoolean("is_completed"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Update
    public void updateEvent(int id, String newTitle, String newDescription, int newCategoryId) {
        String query = "UPDATE events SET title = ?, description = ?, category_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setString(2, newDescription);
            stmt.setInt(3, newCategoryId);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Event updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEvent(int id) {
        String query = "DELETE FROM events WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Event deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mark as Completed
    public void markAsCompleted(int id) {
        String query = "UPDATE events SET is_completed = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Event marked as completed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
