package zhengkaiw.homework2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CacheStream {

    private int duration = 10 * 60;

    public List<Double> compareLastTenMinStream(File file, double input) {
        List<Double> list = new LinkedList<>();
        try {
            WavFile wavFile = WavFile.openWavFile(file);

            int numChannels = wavFile.getNumChannels();
            int framesRead = 0;
            int frames = (int)wavFile.getNumFrames();
            double[] buffer = new double[frames * numChannels];
            do {
                framesRead = wavFile.readFrames(buffer, frames);
            }
            while (framesRead != 0);
            for (int i = buffer.length - 1; i >= 0; i--) {
                if (buffer[i] < input) {
                    list.add(buffer[i]);
                }
            }
            wavFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WavFileException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        File file = new File("/Users/zhengkevin/Repositories/BackendClass/Homework2/src/zhengkaiw/homework2/Ensoniq-ESQ-1-Brass-Ensemble-C4.wav");
        CacheStream cs = new CacheStream();
        System.out.println(cs.compareLastTenMinStream(file, 5));
    }
}
