package PirateModel;

import PirateModel.Entities.*;
import PirateModel.Ships.*;
import PirateModel.Tiles.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameLoader {

    String gamePath;

    JSONObject gameInfo;

    MovementMediator movementMediator;

    Entity player;

    public GameLoader(String gamePath) throws IOException, ParseException {
        this.gamePath = gamePath;

        String infoJSON = loadJSON(gamePath + "/info.json");
        JSONParser parser = new JSONParser();

        this.gameInfo = (JSONObject) parser.parse(infoJSON);

        movementMediator = new MovementMediator();
    }

    public PirateGame loadGame() throws IOException, ParseException {
        Grid mainGrid = loadGrid("MainGrid");
        this.player = loadPlayer();
        loadEntities();
        PirateGame game = new PirateGame(mainGrid, movementMediator, player);

        return game;
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

        ArrayList<Integer> tileIDs = new ArrayList<>();

        for(int i = 0; i < width; i++) {
            JSONArray gridYArr = (JSONArray) gridArr.get(i);
            for(int j = 0; j < height; j++) {
                JSONObject tCon = (JSONObject) gridYArr.get(j);
                newTileGrid[i][j] = generateTileContainer(tCon, i, j, ((Long) gameInfo.get("reservedTileID")).intValue() + i * width + j);
                tileIDs.add(newTileGrid[i][j].getID());

                this.movementMediator.getTileIDMap().put(newTileGrid[i][j].getID(), newTileGrid[i][j]);
                this.movementMediator.getTileEntities().put(newTileGrid[i][j].getID(), new ArrayList<>());
            }
        }

        Grid newGrid = new Grid(((Long) gridInfo.get("ID")).intValue(), newTileGrid);

        for (int tileID: tileIDs) {
            movementMediator.getTileGrid().put(tileID, newGrid);
        }
        return newGrid;
    }

    private Entity loadPlayer() throws IOException, ParseException {    //TODO SHIPS!!!!
        String entityJSON = loadJSON(gamePath + "/player.json");
        JSONParser parser = new JSONParser();
        JSONObject entityData = (JSONObject) parser.parse(entityJSON);

        Ship ship;
        switch ((String) entityData.getOrDefault("SHIP", "CARAVEL")) {
            case "CARAVEL" -> ship = new Caravel();
            case "BARQUE" -> ship = new Barque();
            case "GALLEY" -> ship = new Galley();
            case "GALLEON" -> ship = new Galleon();
            default -> ship = null;
        }

        Entity player = new Player((String) entityData.get("ID"), movementMediator, new Inventory(), ship);

        TileContainer entityTile = this.movementMediator.getTileIDMap().get(( (Long) entityData.get("START_TILE_ID")).intValue());

        this.movementMediator.getEntityTiles().put((String) entityData.get("ID"), entityTile);

        this.movementMediator.getTileEntities().get(( (Long) entityData.get("START_TILE_ID")).intValue()).add(player);

        return player;
    }

    private void loadEntities() throws IOException, ParseException {
        String entityJSON = loadJSON(gamePath + "/entities.json");
        JSONParser parser = new JSONParser();
        JSONArray entityArr = (JSONArray) parser.parse(entityJSON);

        for(Object entityJSONData: entityArr){
            JSONObject entityData = (JSONObject) entityJSONData;

            Entity newEntity;

            //get Ship
            Ship ship;
            switch ((String) entityData.getOrDefault("SHIP", "CARAVEL")) {
                case "CARAVEL" -> ship = new Caravel();
                case "BARQUE" -> ship = new Barque();
                case "GALLEY" -> ship = new Galley();
                case "GALLEON" -> ship = new Galleon();
                default -> ship = null;
            }

            switch ((String) entityData.getOrDefault("TYPE", "NPC")) {
                case "NPC" -> newEntity = new NPC((String) entityData.get("ID"), this.movementMediator, ship, player);
                case "STORYNPC" -> newEntity = new StoryNPC((String) entityData.get("ID"), this.movementMediator, ship, player);
                default -> newEntity = new NPC((String) entityData.get("ID"), this.movementMediator, ship, player);
            }

            TileContainer entityTile = this.movementMediator.getTileIDMap().get(( (Long) entityData.get("START_TILE_ID")).intValue());

            this.movementMediator.getEntityTiles().put((String) entityData.get("ID"), entityTile);

            this.movementMediator.getTileEntities().get(( (Long) entityData.get("START_TILE_ID")).intValue()).add(newEntity);

        }
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

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = "";
        while (line != null) {
            JSONTextBuilder.append(line);
            line = reader.readLine();
        }
        JSONText = JSONTextBuilder.toString();

        reader.close();

        return JSONText;
    }

    public MovementMediator getMovementMediator() {
        return movementMediator;
    }
}
