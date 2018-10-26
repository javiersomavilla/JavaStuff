package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    private static final String CSV_SEPARATOR = ";";
    // MAC OS X Path --> /Users/user.name/Desktop/filename
    public static final String fileToRead = "C:\\Users\\javier.somavilla.ACCELYA\\Desktop\\archivo.txt";
    public static final String fileToWrite = "C:\\Users\\javier.somavilla.ACCELYA\\Desktop\\archivoCopia.txt";
    public static final String dnisFile = "C:\\Users\\javier.somavilla.ACCELYA\\Desktop\\dnis.txt";
    public static final String csvNumbers = "C:\\Users\\javier.somavilla.ACCELYA\\Desktop\\numbers.csv";
    public static final String numbersResult = "C:\\Users\\javier.somavilla.ACCELYA\\Desktop\\numbersResult.txt";

    public static void main(String[] args) {
//        pintaFicheroPorPantalla();
//        duplicaFichero();
//        checkDniFile();
//        processCsvNumbers();
    }
    
    /***********************************************************************************************
     ** Metodo que lee un csv donde cada columna puede contener caracteres aleatorios o numeros.
     ** suma todos los numeros de una misma fila y reporta el resultado en un nuevo fichero txt
     **********************************************************************************************/
    private static void processCsvNumbers(){
        FileWriter txtResult = null;
        try {
            txtResult = new FileWriter(numbersResult);

            File csv = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                csv = new File(csvNumbers);
                fr = new FileReader(csv);
                br = new BufferedReader(fr);

                String line;
                int lineNumber = 1;
                while ((line = br.readLine()) != null) {
                    txtResult.write(processLine(line, lineNumber));
                    lineNumber++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != txtResult){
                    txtResult.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static String processLine(String line, int lineNumber){
        StringBuffer sb = new StringBuffer();
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("-- Line "+lineNumber+"\t--> "+line+"\n");
        sb.append("--------------------------------------------------------------------------------\n");
        
        int total = 0;
        String [] csvCells = line.split(CSV_SEPARATOR);
        
        for(int i=0; i<csvCells.length; i++){
            try{
                total += Integer.parseInt(csvCells[i]);
            }catch(Exception e){}
        }
        
        sb.append("Total = "+total+"\n\n");
        
        return sb.toString();
    }
    
    /***********************************************************************************************
     ** Metodo que comprueba la validez de los dni's de un fichero (1 solo dni por linea) y muestra
     ** el resultado por la consola
     **********************************************************************************************/
    private static void checkDniFile(){
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(dnisFile);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String validation = validateDniString(line);
                validation = validation.isEmpty() ? "DNI correcto" : validation;
                System.out.println(lineNumber+":\t"+line+"\t--> "+validation);
                lineNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    private static String validateDniString(String dni){
        String validation = "";
        
        if(dni.length() == 9){

            boolean numbersCorrect = true;
            for(int i=0; i<8 && numbersCorrect; i++){
                if(Character.getNumericValue(dni.charAt(i)) < 0){
                    numbersCorrect = false;
                }
            }
            
            if(numbersCorrect && Character.isLetter(dni.charAt(8))){
                String dniLetter = dni.substring(8);
                
                if(!dniLetter.equalsIgnoreCase(calculateDniLetter(dni))){
                    validation = "Error, la letra del dni no concuerda con sus digitos.";
                }
                
            }else{
                validation = "Error, dni mal formado, debe contener 8 digitos seguido de 1 letra.";
            }
        }else{
            validation = "Error, el dni no tiene un numero correcto de caracteres.";
        }
        
        return validation;
    }
    
    private static String calculateDniLetter(String dni){
        String [] letterAsignation = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        
        int dniNumber = Integer.parseInt(dni.substring(0,8));
        int index = dniNumber % 23;
        
        return letterAsignation[index];
    }

    /***********************************************************************************************
     ** Metodo que duplica un fichero
     **********************************************************************************************/
    private static void duplicaFichero() {
        FileWriter duplicatedFile = null;
        try {
            duplicatedFile = new FileWriter(fileToWrite);

            File fileToBeDuplicated = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                fileToBeDuplicated = new File(fileToRead);
                fr = new FileReader(fileToBeDuplicated);
                br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                   duplicatedFile.write(line+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != duplicatedFile){
                    duplicatedFile.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /***********************************************************************************************
     ** Metodo que pinte por pantalla todas y cada una de las lineas de un fichero de texto 
     **********************************************************************************************/
    private static void pintaFicheroPorPantalla() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(fileToRead);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
