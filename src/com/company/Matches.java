package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Matches implements SQLObject {
    String partName;
    String player;
    int part_id;
   int matches;
   float score;

    public Matches(String partName, String player, int part_id, int matches, float score) {
        this.partName = partName;
        this.player = player;
        this.part_id = -1;
        this.matches = matches;
        this.score = score;
    }

    public Matches(ResultSet result) {
        try {
            part_id = result.getInt("Part ID");
            partName = result.getString("Part name");
            player = result.getString("Player");
            matches = result.getInt("Matches");
            score = (float) result.getDouble("Score");
        } catch (SQLException bs) {
            bs.printStackTrace();
        }
    }

    @Override
    public void add_to_DB(Statement stmt) {
        String query = "INSERT INTO 'base' ('part_id', 'partName', 'player', matches, score)"+
                "VALUES ('"+part_id+"', '"+partName+"', '"+
                player+"', '"+matches+"', '"+score+"')";
        //System.out.println(query);
        try {
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
