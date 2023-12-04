package PirateModel;

import PirateModel.Tiles.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {

    String gamePath;

    JSONObject gameInfo;

    public GameLoader(String gamePath) throws IOException, ParseException {
        this.gamePath = gamePath;

        String infoJSON = loadJSON(gamePath + "/info.json");
        JSONParser parser = new JSONParser();

        this.gameInfo = (JSONObject) parser.parse(infoJSON);
    }

    public Grid loadGrid(String path) throws IOException, ParseException {   //TODO: MovementMediator integration
        String gridJSON = loadJSON(gamePath + "/" + path + "/grid.json");
        String gridInfoJSON = loadJSON(gamePath + "/" + path + "/gridInfo.json");
        JSONParser parser = new JSONParser();
        JSONArray gridArr = (JSONArray) parser.parse(gridJSON);
        JSONObject gridInfo = (JSONObject) parser.parse(gridInfoJSON);

        int width = ((Long) gridInfo.get("gridWidth")).intValue();
        int height =  ((Long) gridInfo.get("gridHeight")).intValue();

        TileContainer[][] newTileGrid = new TileContainer[width][height];

        for(int i = 0; i < width; i++) {
            JSONArray gridYArr = (JSONArray) gridArr.get(i);
            for(int j = 0; j < height; j++) {
                JSONObject tCon = (JSONObject) gridYArr.get(j);
                newTileGrid[i][j] = generateTileContainer(tCon, i, j, ((Long) gameInfo.get("reservedTileID")).intValue() + i * width + j);
            }
        }

        return new Grid(((Long) gridInfo.get("ID")).intValue(), newTileGrid);
    }

    private TileContainer generateTileContainer(JSONObject object, int x, int y, int defaultID) {
        Tile newTile;

        switch ((String) object.getOrDefault("TYPE", "WATER")) {
            case "WATER" -> newTile = new Water(null);                          // TODO: ADD EVENT PARSING
            case "ISLAND" -> newTile = new Island(null);
            case "PORT" -> newTile = new Port(null);
            case "TREASURE ISLAND" -> newTile = new TreasureIsland(null);
            default -> newTile = new Water(null);
        }

        return new TileContainer(newTile, ((Number) object.getOrDefault("ID", defaultID)).intValue(), x, y);
    }

    private String loadJSON(String fileName) throws IOException {
        StringBuilder JSONTextBuilder = new StringBuilder();
        String JSONText;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line = "";
            while (line != null) {
                JSONTextBuilder.append(line);
                line = reader.readLine();
            }
            JSONText = JSONTextBuilder.toString();
        }
        catch (Exception e) {
            throw e;
        }

        return JSONText;
    }
}
