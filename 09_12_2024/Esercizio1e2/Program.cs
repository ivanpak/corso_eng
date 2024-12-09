using System;
using System.Threading.Tasks.Dataflow;

public class Program
{
    public static void Main(string[] args)
    {
        func1();
        // func2();
        


    }

    static void func2() {
        Console.WriteLine("Inserisci frase");
        string s = Console.ReadLine();
        string[] words = s.Split(" ");
        Console.WriteLine($"la frase ha {words.Length} parole");
        foreach (var word in words) {
            Console.WriteLine(word + " ");
        }
    }

    static void func1() {
        List<int> listPari = new List<int>();
        List<int> listDispari = new List<int>();
        
        while (true) {
            Console.WriteLine("-------------------");
            Console.WriteLine("inserire un numero");
            string s = Console.ReadLine();
            int i1;
            int.TryParse(s, out i1);
            string parita = "pari";
            if(i1%2==0) {
                parita = "pari";
                listPari.Add(i1);
            } else {
                parita = "dispari";
                listDispari.Add(i1);
            }
            Console.WriteLine($"il numero {i1} è {parita}");

            Console.Write("mostrare pari o dispari?");
            string toShow = Console.ReadLine();
            if(toShow.Equals("pari")) {
                foreach (int number in listPari)
                {
                    Console.Write("{0} ", number);
                }
                Console.WriteLine("");
            } else if(toShow.Equals("dispari")) {
                foreach (int number in listDispari)
                {
                    Console.Write("{0} ", number);
                }
                Console.WriteLine("");
            }

            Console.Write("uscire? (s/n)");
            string exit = Console.ReadLine();
            if(exit.Equals("s")) {
                break;
            }
        }
    }
}