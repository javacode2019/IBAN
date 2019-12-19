package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadAndWrite {
    public void readAndWrite(Map<String, Integer> map) {
        try {

            String name=getFileName();
            Scanner scanner = new Scanner(new File(name));
            List<String> validatedList = new ArrayList<>();
            String data;
            while (scanner.hasNextLine()) {
                String iBAN = scanner.nextLine();
                String ibanUperCaseWithoutSpace = iBAN.toUpperCase().replaceAll("\\s", "");
                String countryCode = ibanUperCaseWithoutSpace.substring(0, 2);
                int iBANLength = ibanUperCaseWithoutSpace.length();
                boolean checkCountryCode = map.containsKey(countryCode);
                if (checkCountryCode && iBANLength == map.get(countryCode)) {
                    data = ibanUperCaseWithoutSpace + ";true";
                } else {
                    data = ibanUperCaseWithoutSpace + ";false";
                }
                validatedList.add(data);
            }
            FileWriter writer = new FileWriter((name+".out"));
            for(String str: validatedList) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
            System.out.println("Validated list saved in: "+name+".out file");
            System.exit(0);

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Put your data file to project folder and enter input data file name with extension(examples: data.txt):");
        String name="";
        return scanner.nextLine();
    }
}
