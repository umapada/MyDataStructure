package Cmpny.Extra;

import java.util.*;
// A job has a name and one or more instances. Each instance has a globally unique ID number.
//Given this list of input lines and a positive integer K:
//
//Started name=dump_logs jobid=f863
//Started name=dump_logs jobid=g301gas
//…
//Ended jobid=f863 time=1021
//Started name=grep_logs jobid=ac3de
//Ended jobid=g301gas time=1343
//Started name=read_logs jobid=r0eas
//
//Started name=write_logs jobid=dg2dz
//Ended jobid=r0eas time=103
//Ended jobid=ac3de time=52
//
//Print out the names of the K distinct jobs (not job instance IDs, so de-dupe on job name) with the longest running individual job instances (no totaling). Note they can be out of order.
//So the output for the above for K=2 would be:
//
//Name Time
//dump_logs 1343
//read_logs 103

class Hulu {
    public static void main(String[] args) {
        String[] lines = new String[] {
                "Started name=dump_logs jobid=f863",
                "Started name=dump_logs jobid=g301gas",
                // ...
                "Ended jobid=f863 time=1021",
                "Started name=grep_logs jobid=ac3de",
                "Ended jobid=g301gas time=1343",
                "Started name=read_logs jobid=r0eas",
                // ...
                "Started name=write_logs jobid=dg2dz",
                "Ended jobid=r0eas time=103",
                "Ended jobid=ac3de time=52"
        };
                    analyze(lines,2);
    }


    public static void analyze(String[] lines, Integer k) {

        Map<String, String> startedMap = new HashMap<>();
        Map<String, Integer> endeddMap = new HashMap<>();

        for (String line : lines) {

            String[] lineSplit = line.split(" ");
            if(lineSplit[0].equals("Started")){

                String[] jobId = lineSplit[2].split("=");
                String [] name = lineSplit[1].split("=");

                startedMap.put(jobId[1],name[1] );

            }else{
                String[] jobId = lineSplit[1].split("=");
                String [] time = lineSplit[2].split("=");

                endeddMap.put(jobId[1], Integer.parseInt(time[1]));
            }
        }

        List <String> jobidList = new ArrayList<>();

        class Count {
            int count = 0;
        }

        Count ct = new Count();

        endeddMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(x->{
                String jobId = x.getKey();
                Integer time = x.getValue();
                String jobName = startedMap.get(jobId);

                if(ct.count >= k){
                    return;
                }

                if(!jobidList.contains(jobName) && ct.count < k){
                    System.out.println(jobName +"  " + time );
                    ct.count  ++;
                    jobidList.add(jobName);
                }
        });
    }
}
