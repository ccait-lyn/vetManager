//AppointmentQueue For Current Day 
//EX: Monday: |First | Max <-Whiskers <- Remy  | Last|
//Because we are not doing time or a queue for the week, it will work according to first to schedule.

public class AppointmentQueue {


//Queue and constructor
    private static class Node{
        Patient_Info patient;//Current patient data
        Node next;//Next Patient

        Node(Patient_Info patient) {
            this.patient = patient;
            this.next = null;
        }
    }
    
    private Node head;//First in Queue
    private Node tail;//Last in Queue
    private int size; //Total number of patients in the days Queue

    public AppointmentQueue(){//Constructor, empty queue
        this.head= null;
        this.tail= null;
        this.size= 0;
    }
  //Queue and constructor

  //METHOD: Add patient, will add to back of queue 
    public void addToQueue(Patient_Info patient){
        Node newNode= new Node(patient);
        
        if(isEmpty()){
            head= newNode;
            tail=newNode;
        }else {
            tail.next = newNode; 
            tail= newNode; //node becomes new tail
        }
        size++;//increase current patients for day
    }

    //METHOD: Remove patient from queue, when a patient has been handled, vetmanagers may remove them to indicate next patients turn
    public Patient_Info removeFromQueue()
	{
		if(head == null)
		{
			return null;
		}
		
		Patient_Info result = head.patient;
		
		head = head.next;
		size--;
		
		if(head == null)
		{
			tail = null;
		}
		
		return result;
	}
   

  //METHOD: Check if the queue is empty, if no head its empty
    public boolean isEmpty(){
        return head==null;
    }
    
  //GETTER: Amount of patients in queue
    public int size(){
        return size;
    }


  
  //METHOD: Check the next patient in line's info
    public Patient_Info headInfo(){
        if(isEmpty()){
            return null;
        }
        return head.patient;
    }


	//METHOD: Display all current appointments
	public void displayAppointments(){
		if(isEmpty()){
			System.out.println("No appointments for today!");
			return;
		}
		Node current=head;
		int index=1;
		while(current !=null){
			System.out.println("Appointment #"+index++);
			System.out.println("current.patient.toString());
			System.out.println("______________________");//This formatting isnt tested and was only added for my visual sake, subject ot change
			current= current.next;
		}
	}
	
}

  
