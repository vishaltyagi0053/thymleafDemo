package com.th.bootcamp.enm;

import java.util.Arrays;
import java.util.List;

public enum Competency {
   JVM("JVM"),
   MEAN("MEAN"),
   DEVOPS("DevOps"),
   QA("QA");
   String value;
   Competency(String competency) {
       value = competency;
   }
   public String getValue() {
       return value;
   }

   public static List<Competency> getValues(){
      return Arrays.asList(JVM,MEAN,DEVOPS,QA);
   }
}
