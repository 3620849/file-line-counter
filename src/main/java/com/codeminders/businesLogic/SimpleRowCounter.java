package com.codeminders.businesLogic;

import com.codeminders.businesLogic.model.CountedFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleRowCounter implements RowCounter {
    public void countRows(String path) {
        File file = new File(path);
        if(file.isFile()){
            System.out.println(countRowInFile(file));
        }if(file.isDirectory()){
            CountedFile tree = buildFileTree(file );
            tree.setName("root");
            printTree(tree,"");
        }
    }

    private void printTree(CountedFile tree,String spacer) {
        if(tree==null)return;
        System.out.println(spacer+tree);
        if(tree.getChilds()!=null && tree.getChilds().size()>0){
            tree.getChilds().forEach(child->{
                printTree(child,spacer+" ");
            });
        }
    }

    private CountedFile buildFileTree(File folder ) {
        CountedFile node = new CountedFile();
        node.setName(folder.getName());
        long total = 0;
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.isFile()){
                CountedFile fileSummary = countRowInFile(fileEntry);
                total+=fileSummary.getCount();
                node.putChild(fileSummary);
            }if(fileEntry.isDirectory()){
                CountedFile subTree =  buildFileTree(fileEntry);
                total+=subTree.getCount();
                node.putChild(subTree);
            }
        }
        node.setCount(total);
        return node;
    }

    private CountedFile countRowInFile(File file ) {
        long rows = 0;
        String code = "";
        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            //read all in one big string
            code = readBigStringIn(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //remove all comments
        code = code.replaceAll("/\\*(?:.|[\\n\\r])*?\\*/", "");

        String[] split = code.split("\n");
        List<String> list = Arrays.asList(split);

        //remove empty  and whitespaces strings
        list = list.stream().map(s -> s.trim()).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        rows = list.size();

        return new CountedFile(rows,file.getName());
    }
    private  String readBigStringIn(BufferedReader buffIn) throws IOException {
        StringBuilder everything = new StringBuilder();
        String line;
        while ((line = buffIn.readLine()) != null) {
            everything.append("\n" + line);
        }
        return everything.toString();
    }


}

