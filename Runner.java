// Forrit hefur galla. Raðar alltaf fylki í vaxandi röð eftir fyrstu röðun á því. Vantar að leysa að afrita ekki vistföng fylkja heldur gildi þeirra.
import java.util.Random;
public class Runner {
    public static void main(String[] args) {
        tester();
    }
    public static void tester() {
        Random rand = new java.util.Random();
        long[] b = new long[2];
        long[] c = new long[1000];
        int[] a = new int[1000];
        for(int i=0; i!=1000; i++) {
            a[i]=i;
        }
        System.out.println("Röðunarreiknirit 1-10 frá efsta til neðsta.");
        System.out.println("Raðað var 1000 staka fylki sem var í vaxandi röð");
        System.out.println("Tölur eru meðaltöl 1000 keyrslna.");
        System.out.println("Tímataka í ns: ");
        for(int i=1; i!=11; i++) {
            b = multirun(a, i);
            c[i] = b[1];
            System.out.println(b[0]);
        }
        System.out.println("Minnisnotkun í B: ");
        for(int i=1; i!=11; i++) {
            System.out.println(c[i]);
        }
        for(int i=0; i!=1000; i++) {
            a[i]=rand.nextInt(100);
        }
        System.out.println("Röðunarreiknirit 1-10 frá efsta til neðsta.");
        System.out.println("Raðað var 1000 staka fylki sem var slembið.");
        System.out.println("Tölur eru meðaltöl 1000 keyrslna.");
        System.out.println("Tímataka í ns: ");
        for(int i=1; i!=11; i++) {
            b = multirun(a, i);
            c[i] = b[1];
            System.out.println(b[0]);
        }
        System.out.println("Minnisnotkun í B: ");
        for(int i=1; i!=11; i++) {
            System.out.println(c[i]);
        }
    }

    // Tekur inn fylki til röðunar og númersvísi sem samsvarar númeri á röðunaraðferð í Sorter. 
    // Keyrir run(a,fall) 1000 sinnum fyrir tiltekna röðunaraðferð á 
    public static long[] multirun(int[]  a, int fall) {
        long[] b = {0, 0};
        long[] tmp = new long[2];
        int[] c = new int[1000];
        for(int i=0; i!=1000; i++) {
            c = a;
            tmp = run(c, fall);
            b[1] += tmp[1];
            b[0] += tmp[0];
        }
        b[1] = b[1]/1000;
        b[0] = b[0]/1000;
        return b;
    }

    // Tekur inn fylki til röðunar og númersvísi sem samsvarar númeri á röðunaraðferð í Sorter.
    public static long[] run(int[] a, int fall) {
        final long endTime;
        final long startTime; 
        switch (fall) {
            case 1:
                startTime = System.nanoTime();
                try {
                    Sorter.s1(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 2:
                startTime = System.nanoTime();
                try {
                    Sorter.s2(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 3:
                startTime = System.nanoTime();
                try {
                    Sorter.s3(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 4:
                startTime = System.nanoTime();
                try {
                    Sorter.s4(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 5:
                startTime = System.nanoTime();
                try {
                    Sorter.s5(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 6:
                startTime = System.nanoTime();
                try {
                    Sorter.s6(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 7:
                startTime = System.nanoTime();
                try {
                    Sorter.s7(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 8:
                startTime = System.nanoTime();
                try {
                    Sorter.s8(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            case 9:
                startTime = System.nanoTime();
                try {
                    Sorter.s9(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
            default:
                startTime = System.nanoTime();
                try {
                    Sorter.s10(a);
                } finally {
                    endTime = System.nanoTime();
                }
                break;
        }
        final long duration = endTime - startTime;
        long memory = Runtime.getRuntime().totalMemory()-
            Runtime.getRuntime().freeMemory();
        long[] b = {duration, memory};
        return b;
    }
}

