package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import okhttp3.internal.http2.Hpack;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGeneration {

    @Parameter(names = "-c", description =  "Group count")
    public  int count;

    @Parameter(names = "-f", description =  "Target file")
    public String file;

    @Parameter(names = "-d", description =  "Date format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGeneration generator = new GroupDataGeneration();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
           // int count = Integer.parseInt(args[0]);
        }
        catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupDate> groups = generateGroups(count);
        if (format.equals("cvs")) {
            saveAsCsv(groups, new File(file));
        }
        else if(format.equals("xml")) {
            saveAsXml(groups, new File(file));
        }
        else if(format.equals("json")) {
            saveAsJson(groups, new File(file));
        }
        else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<GroupDate> groups, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<GroupDate> groups, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(GroupDate.class);
        String xml = xStream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private  void saveAsCsv(List<GroupDate> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (GroupDate group: groups) {
        writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),group.getFooter()));
        }
        writer.close();
    }

    private  List<GroupDate> generateGroups(int count) {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        for (int i = 0 ; i <count;i++){
            groups.add(new GroupDate().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
            return groups;
    }
}
