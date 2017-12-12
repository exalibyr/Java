import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogic {

    //private Cell currentCell;
    private MyTableModel gameFieldData;
    private JTable gameFieldTable;

    private int rowAmount;
    private int columnAmount;
    private Cell[][] currentGeneration;
    private int aliveCellsAmount;
    private int aliveNeighborsAmount;
    private Timer gameExecutionTimer;

    private boolean generationsHasDifference;
    private boolean isGameRunning;
    private boolean unlimitedBorders;
    private boolean drawingMode;
    private boolean isMousePressed;
    private boolean isFirstCell;
    private boolean firstCellState;

    GameLogic(JTable gameFieldTable, MyTableModel gameFieldData)
    {
        this.gameFieldData = gameFieldData;
        this.gameFieldTable = gameFieldTable;
        rowAmount = gameFieldData.getRowCount();
        columnAmount = gameFieldData.getColumnCount();
        currentGeneration = CellsCreator.createEmpty(rowAmount, columnAmount);
        aliveCellsAmount = 0;
        isGameRunning = false;
        unlimitedBorders = false;
        drawingMode = false;
    }

    public boolean isDrawingMode() {
        return drawingMode;
    }

    public void setDrawingMode(boolean drawingMode) {
        this.drawingMode = drawingMode;
    }

    public boolean isUnlimitedBorders() {
        return unlimitedBorders;
    }

    public void setUnlimitedBorders(boolean unlimitedBorders) {
        this.unlimitedBorders = unlimitedBorders;
    }

    public void press(){
        isMousePressed = true;
        gameExecutionTimer = new Timer();
        isFirstCell = true;
        gameExecutionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Point point = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(point, gameFieldTable);
                int rowIndex = point.y / gameFieldTable.getRowHeight();
                int columnIndex = point.x / gameFieldTable.getColumnModel().getTotalColumnWidth();
                if(isFirstCell){
                    firstCellState = gameFieldData.getCellState(rowIndex, columnIndex);
                    isFirstCell = false;

                }
                if(gameFieldData.getCellState(rowIndex, columnIndex) == firstCellState){
                    gameFieldData.setCellState(!firstCellState, rowIndex, columnIndex);
                    if(firstCellState){
                        aliveCellsAmount--;
                    }
                    else {
                        aliveCellsAmount++;
                    }
                    gameFieldData.setValueAt(gameFieldData.getValueAt(rowIndex, columnIndex),
                            rowIndex, columnIndex);
                }
                if(!isMousePressed){
                    gameExecutionTimer.cancel();
                    gameExecutionTimer.purge();
                }
            }
        }, 0, 1);
    }

    public void setMouseReleased() {
        if(isMousePressed){
            isMousePressed = false;
        }
    }

    public void changeCellState(int rowIndex, int columnIndex){
//        currentCell = gameFieldData.getValueAt(rowIndex, columnIndex);
//        if(currentCell.isAlive()) {
//            currentCell.setState(false);
//            aliveCellsAmount--;
//        }
//        else {
//            currentCell.setState(true);
//            aliveCellsAmount++;
//        }
//        gameFieldData.setValueAt(currentCell, rowIndex, columnIndex);
        if(gameFieldData.getCellState(rowIndex, columnIndex)) {
            gameFieldData.setCellState(false, rowIndex, columnIndex);
            aliveCellsAmount--;
        }
        else {
            gameFieldData.setCellState(true, rowIndex, columnIndex);
            aliveCellsAmount++;
        }
        gameFieldData.setValueAt(gameFieldData.getValueAt(rowIndex, columnIndex), rowIndex, columnIndex);
    }

    private void evaluateInternalCells(){
        for (int i = 1; i < rowAmount - 1; i++) {
            for (int j = 1; j < columnAmount - 1; j++) {

                if(currentGeneration[i - 1][j - 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i - 1][j].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i - 1][j + 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i][j - 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i][j + 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i + 1][j - 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i + 1][j].isAlive()){
                    aliveNeighborsAmount++;
                }
                if(currentGeneration[i + 1][j + 1].isAlive()){
                    aliveNeighborsAmount++;
                }
                checkCell(i, j);

            }
        }
    }

    private void checkCell(int rowIndex, int columnIndex){
        if(!currentGeneration[rowIndex][columnIndex].isAlive()){
            if(aliveNeighborsAmount == 3){
                changeCellState(rowIndex, columnIndex);
            }
        }
        else {
            if((aliveNeighborsAmount != 2) && (aliveNeighborsAmount != 3)){
                changeCellState(rowIndex, columnIndex);
            }
        }
        aliveNeighborsAmount = 0;
    }

    private void makeOneStep(){
        int i, j;
        aliveNeighborsAmount = 0;
        for (i = 0; i < rowAmount; i++) {
            for (j = 0; j < columnAmount; j++) {
                currentGeneration[i][j].setState(gameFieldData.getCellState(i, j));
            }
        }

        evaluateInternalCells();

        for (i = 1; i < rowAmount - 1; i++) {
            j = 0;
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);

            j = columnAmount - 1;
            if(currentGeneration[i - 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);
        }

        for (j = 1; j < columnAmount - 1; j++){
            i = 0;
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);

            i = rowAmount - 1;
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);
        }

        i = 0;
        j = 0;
        if(currentGeneration[i][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        j = columnAmount - 1;
        if(currentGeneration[i][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        i = rowAmount - 1;
        if(currentGeneration[i][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        j = 0;
        if(currentGeneration[i][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);
    }

    private void makeOneStepUnlimitedBorders(){
        int i, j;
        aliveNeighborsAmount = 0;
        for (i = 0; i < rowAmount; i++) {
            for (j = 0; j < columnAmount; j++) {
                currentGeneration[i][j].setState(gameFieldData.getCellState(i, j));
            }
        }

        evaluateInternalCells();

        //borders evaluating--------------------------------------
        for (i = 1; i < rowAmount - 1; i++) {
            j = 0;
            if(currentGeneration[i - 1][columnAmount - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][columnAmount - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][columnAmount - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);

            j = columnAmount - 1;
            if(currentGeneration[i - 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][0].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][0].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][0].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);
        }

        for (j = 1; j < columnAmount - 1; j++){
            i = 0;
            if(currentGeneration [rowAmount - 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration [rowAmount - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration [rowAmount - 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i + 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);

            i = rowAmount - 1;
            if(currentGeneration [0][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration [0][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration [0][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j - 1].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j].isAlive()){
                aliveNeighborsAmount++;
            }
            if(currentGeneration[i - 1][j + 1].isAlive()){
                aliveNeighborsAmount++;
            }
            checkCell(i, j);
        }

        i = 0;
        j = 0;
        if(currentGeneration [rowAmount - 1][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [rowAmount - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [rowAmount - 1][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        j = columnAmount - 1;
        if(currentGeneration [rowAmount - 1][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [rowAmount - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [rowAmount - 1][0].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [i][0].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i + 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration [i + 1][0].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        i = rowAmount - 1;
        if(currentGeneration[i - 1][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][0].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][0].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][j - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][0].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);

        j = 0;
        if(currentGeneration[i - 1][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i - 1][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[i][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][columnAmount - 1].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][j].isAlive()){
            aliveNeighborsAmount++;
        }
        if(currentGeneration[0][j + 1].isAlive()){
            aliveNeighborsAmount++;
        }
        checkCell(i, j);
    }

    public boolean isGameFieldEmpty(){
        if(aliveCellsAmount == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isGameRunning(){
        if(isGameRunning){
            return true;
        }
        else{
            return false;
        }
    }

    public void performOneStep(){
        if(unlimitedBorders){
            makeOneStepUnlimitedBorders();
        }
        else{
            makeOneStep();
        }
    }

    public void startGame(JLabel infoLabel, JButton startGameButton, JButton stopGameButton,
                          JButton oneStepButton, JButton cleanCellsButton,
                          JCheckBox unlimitedBordersCheckBox, JCheckBox drawingModeCheckBox)
    {
        startGameButton.setEnabled(false);
        cleanCellsButton.setEnabled(false);
        oneStepButton.setEnabled(false);
        unlimitedBordersCheckBox.setEnabled(false);
        drawingModeCheckBox.setEnabled(false);
        stopGameButton.setEnabled(true);

        isGameRunning = true;
        gameExecutionTimer = new Timer();
        gameExecutionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(unlimitedBorders){
                    makeOneStepUnlimitedBorders();
                }
                else{
                    makeOneStep();
                }
                generationsHasDifference = false;
                for (int i = 0; i < rowAmount; i++) {
                    for (int j = 0; j < columnAmount; j++) {
                        if (currentGeneration[i][j].isAlive() != gameFieldData.getCellState(i, j)) {
                            generationsHasDifference = true;
                        }
                    }
                }
                if(!isGameRunning){
                    gameExecutionTimer.cancel();
                    gameExecutionTimer.purge();
                    return;
                }
                if ((!generationsHasDifference) || (aliveCellsAmount == 0)) {
                    gameExecutionTimer.cancel();
                    gameExecutionTimer.purge();
                    isGameRunning = false;

                    startGameButton.setEnabled(true);
                    cleanCellsButton.setEnabled(true);
                    oneStepButton.setEnabled(true);
                    unlimitedBordersCheckBox.setEnabled(true);
                    drawingModeCheckBox.setEnabled(true);
                    stopGameButton.setEnabled(false);
                    infoLabel.setText("Finished!");
                }
            }
        }, 0, 50);
    }

    public void stopGame(){
        isGameRunning = false;
    }

    public void cleanCells(){
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
//                    currentCell = gameFieldData.getValueAt(i, j);
//                    currentCell.setState(false);
//                    gameFieldData.setValueAt(currentCell, i, j);
                gameFieldData.setCellState(false, i, j);
                gameFieldData.setValueAt(gameFieldData.getValueAt(i, j), i, j);
            }
        }
        aliveCellsAmount = 0;
    }
}
