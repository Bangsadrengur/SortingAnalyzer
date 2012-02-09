import java.util.Random;

public class Stuffster
{
    public static int[] strangeFunction = new int[10]; // Breyta mun halda um vísi á counting sort

    public static long[] sortingSortedTime = new long[10];
    public static long[] sortingSortedMem = new long[10];
    public static long[] sortingSortedWorstTime = new long[10];

    public static long[] sortingRevSortedTime = new long[10];
    public static long[] sortingRevSortedMem = new long[10];
    public static long[] sortingRevSortedWorstTime = new long[10];

    public static long[] sortingRandomTime = new long[10];
    public static long[] sortingRandomMem = new long[10];
    public static long[] sortingRandomWorstTime = new long[10];

    // Keyrslufall
    public static void main(String[] args)
    {
        findStrangeFunction();
        checkSorted();
        checkRevSorted();
        checkRandom();
        
        System.out.println("Working on a presorted array.");
        System.out.println("Function number - Time to complete in ns");
        printer(sortingSortedTime);
        System.out.println("Function number - Memory used in bytes");
        printer(sortingSortedMem);
        System.out.println("Function number - Worst time to complete in ns");
        printer(sortingSortedMem);

        System.out.println("Working on a reverse sorted array.");
        System.out.println("Function number - Time to complete in ns");
        printer(sortingRevSortedTime);
        System.out.println("Function number - Memory used in bytes");
        printer(sortingRevSortedMem);
        System.out.println("Function number - Worst time to complete in ns");
        printer(sortingRevSortedWorstTime);

        System.out.println("Working on a random array.");
        System.out.println("Function number - Time to complete in ns");
        printer(sortingRandomTime);
        System.out.println("Function number - Memory used in bytes");
        printer(sortingRandomMem);
        System.out.println("Function number - Worst time to complete in ns");
        printer(sortingRandomWorstTime);
    }

    // Fallið tekur inn fylki og prentar út númerum fyrir tilheyrandi
    // röðunarfall og niðurstöður í sitt hvorn dálkinn.
    public static void printer(long[] a)
    {
        for(int i=0; i!=10; i++)
        {
            System.out.println(i+1 + " " + a[i]);
        }
    }



    // Fall til að kalla í röðunarföll.
    // Skilar keyrslutíma og minnisnotkun í fylki.
    public static long[] sorter(int[] a, int tilvik)
    {
        final long endTime;
        final long startTime; 
        switch (tilvik) {
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

    // Fall reynir að finna föll sem hegða sér ekki
    // eðlilega ef neikvæð stök eru í fylki til röðunar.
    public static void findStrangeFunction()
    {
        //int[] a = {-2,1,-2};
        int[] a = randomArray();
        for(int i = 1; i!=11; i++)
        {
            try
            {
                sorter(a,i);
            } catch(NegativeArraySizeException e) {
                strangeFunction[0] = i;
            } catch(ArrayIndexOutOfBoundsException f) {
                strangeFunction[1] = i;
            }
        }
        System.out.println("Functions that fail when items in array have negative value: ");
        System.out.println(strangeFunction[0]);
        System.out.println(strangeFunction[1]);
        System.out.println("=================");
    }

    // Fall smíðar 1000 staka slembið fylki til prófunar
    public static int[] randomArray()
    {
        Random rand = new java.util.Random();
        int[] a = new int[1000];
        for(int i = 0; i!=1000; i++)
        {
            a[i] = rand.nextInt();
        }
        return a;
    }

    // Fall smíðar 1000 staka raðað fylki í vaxandi röð til prófunar.
    public static int[] sortedArray()
    {
        int[] a = new int[1000];
        for(int i=0; i!=1000; i++)
        {
            a[i] = i;
        }
        return a;
    }

    // Fall smíðar 1000 staka raðað fylki í dvínandi röð til prófunar.
    public static int[] revSortedArray()
    {
        int[] a = new int[1000];
        for(int i=0; i!=1000; i++)
        {
            a[i] = 1000-i;
        }
        return a;
    }

    // Fall tekur raðað fylki og prufar að raða því 1000 sinnum með hverri aðferð og tekur meðaltal útkoma.
    public static void checkSorted()
    {
        int[] a = sortedArray();
        long[] timeCollector = new long[10];
        long[] timeWorstCollector = new long[10];
        long[] memoryCollector = new long[10];
        long[] tmp = new long[2];
        for(int i=0; i!=1000; i++) 
        {
            for(int j=1; j!=11; j++)
            {
                tmp = sorter(a,j);
                timeCollector[j-1] += tmp[0];
                if(tmp[0]>timeWorstCollector[j-1]) { timeWorstCollector[j-1] = tmp[0]; }
                memoryCollector[j-1] += tmp[1];
            }
        }
        for(int i=0; i!=10; i++)
        {
            timeCollector[i] = timeCollector[i]/1000;
            memoryCollector[i] = memoryCollector[i]/1000;
        }
        sortingSortedTime = timeCollector;
        sortingSortedWorstTime = timeWorstCollector;
        sortingSortedMem = memoryCollector;
    }

    // Fall tekur "öfugt" röðuð fylki og prufar að raða þeim 1000 sinnum með hverri aðferð og tekur meðaltal útkoma.
    public static void checkRevSorted()
    {
        int[] a = revSortedArray();
        long[] timeCollector = new long[10];
        long[] timeWorstCollector = new long[10];
        long[] memoryCollector = new long[10];
        long[] tmp = new long[2];
        for(int i=0; i!=1000; i++) 
        {
            for(int j=1; j!=11; j++)
            {
                tmp = sorter(a,j);
                timeCollector[j-1] += tmp[0];
                if(tmp[0]>timeWorstCollector[j-1]) { timeWorstCollector[j-1] = tmp[0]; }
                memoryCollector[j-1] += tmp[1];
                a = revSortedArray();
            }
        }
        for(int i=0; i!=10; i++)
        {
            timeCollector[i] = timeCollector[i]/1000;
            memoryCollector[i] = memoryCollector[i]/1000;
        }
        sortingRevSortedTime = timeCollector;
        sortingRevSortedWorstTime = timeWorstCollector;
        sortingRevSortedMem = memoryCollector;
    }
    
    // Fall tekur slembin fylki og prufar að raða þeim 1000 sinnum með hverri aðferð, sem ekki 
    // skilar villum í röðun með neikvæð stök, og tekur meðaltal útkoma.
    public static void checkRandom()
    {
        int[] a = randomArray();
        long[] timeCollector = new long[10];
        long[] timeWorstCollector = new long[10];
        long[] memoryCollector = new long[10];
        long[] tmp = new long[2];
        for(int i=0; i!=1000; i++) 
        {
            for(int j=1; j!=11; j++)
            {
                if(j==strangeFunction[0]) {continue;}
                if(j==strangeFunction[1]) {continue;}
                tmp = sorter(a,j);
                timeCollector[j-1] += tmp[0];
                if(tmp[0]>timeWorstCollector[j-1]) { timeWorstCollector[j-1] = tmp[0]; }
                memoryCollector[j-1] += tmp[1];
                a = randomArray();
            }
        }
        for(int i=0; i!=10; i++)
        {
            timeCollector[i] = timeCollector[i]/1000;
            memoryCollector[i] = memoryCollector[i]/1000;
        }
        sortingRandomTime = timeCollector;
        sortingRandomWorstTime = timeWorstCollector;
        sortingRandomMem = memoryCollector;
    }
}
