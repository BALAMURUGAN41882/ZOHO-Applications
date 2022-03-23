import java.util.*;

public class Main {
	static Graph graph = new Graph(5);//CREATING AN OBJECT FOR GRAPH 
	//ADDING THE PASSENGER TO THE QUEUE
	public static void add_Passenger(ArrayList<Passenger> queue,int age, String name, char destination) {
		queue.add(new Passenger(age,name,destination));
	}
	//FIND MAXAGE IN THE QUEUE
	public static void start_pod(ArrayList<Passenger> queue) {
		int maxAge=queue.get(0).age,j=0;
		for(int i=1;i<queue.size();i++) {
			if(queue.get(i).age>maxAge) {
				maxAge=queue.get(i).age;
				j=i;
			}
		}
		Passenger passenger = queue.get(j);
		System.out.print(passenger.name+" ");
		graph.best=new ArrayList<>();
		graph.getPaths('A', passenger.destination);
		for(int i=0;i<graph.best.size();i++) {
			System.out.print(graph.best.get(i)+" ");
			//PRINT THE SHORTEST PATH TO THE DESTINATION
		}
		System.out.println();
		queue.remove(j);
	}
	public static void print_Q(ArrayList<Passenger> queue) {
		System.out.println(queue.size());
		//PRINT THE NUMBER OF ELEMENTS IN THE QUEUE
		for(Passenger passenger:queue) {
			System.out.println(passenger);
			//PRINT THE OBJECT IN A LIST
			
		}
	}
	public static void main(String[] args) {
		ArrayList<Passenger> queue = new ArrayList<Passenger>();
		Scanner scanner = new Scanner(System.in);
		String in[];
		in = scanner.nextLine().split(" ");
		int number = Integer.parseInt(in[1]);
		char a = in[2].charAt(0);
		for(int i=0;i<number;i++) {
			in = scanner.nextLine().split(" ");
			graph.addEdge(in[0].charAt(0), in[1].charAt(0));
			//ADDING THE EDGES TO THE GRAPH WHILE GETTING FROM USER ITSELF
		}
		while(true) {
			in = scanner.nextLine().split(" ");
			if(in[0].equals("ADD_PASSENGER")) {
				int n = Integer.parseInt(in[1]);
				for(int i=0;i<n;i++) //THE LOOP RUNS DEPEND UPON USER INPUTS
				{
					String input[] = scanner.nextLine().split(" ");
					add_Passenger(queue, Integer.parseInt(input[1]), input[0], input[2].charAt(0));
				}
			}
			if(in[0].equals("START_POD")) {
				int n = Integer.parseInt(in[1]);
				for(int i=0;i<n;i++)//THE LOOP RUNS DEPEND UPON USER INPUTS
				{
					start_pod(queue);//FUNCTION CALL TO PRINT OLDEST AGE'S SHORTEST PATH
				}
			}
			if(in[0].equals("PRINT_Q")) //PRINT THE REMAINING OBJECT IN THE QUEUE
			{
				print_Q(queue);
			}			
		}
	}
}