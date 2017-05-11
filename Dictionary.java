import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


class Dictionary extends JFrame implements ActionListener 
{       
     static  BST w;
        
	private	JTabbedPane tabbedPane;
	private	JPanel	panel1;
	private	JPanel	panel2;
	private	JPanel	panel3;
	private	JPanel	panel4;
        JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7;
        JTextField text,text1,text3,text4,text5,text7;
        JTextArea text2,text6;

	public Dictionary()
	{
				
		setTitle( "Dictionary" );
		setSize( 500, 500 );
		setLocation(500,200);
		//setBackground( Color.gray );
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.lightGray);
		topPanel.setLayout( new BorderLayout() );
		
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		createPage3();
		createPage4();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Search", panel1 );
		tabbedPane.addTab( "Synonyms", panel2 );
		tabbedPane.addTab( "Insert", panel3 );
		tabbedPane.addTab( "Delete", panel4 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}

	

	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout( null );
		panel1.setBackground(Color.gray);

		JLabel label1 = new JLabel( "Find What:" );
		label1.setBounds( 20, 15, 150, 20 );
		panel1.add( label1 );

		text1 = new JTextField();
		text1.setBounds( 20, 40, 150, 20 );
		panel1.add( text1 );

		JLabel label2 = new JLabel( "Meaning:" );
		label2.setBounds( 20, 70, 150, 20 );
		panel1.add( label2 );

		
		
		text2 = new JTextArea();
		text2.setBounds( 20, 100, 450, 100 );
		panel1.add( text2 );
		text2.setEditable(false);
                text2.setFont(new Font("Calibri", Font.BOLD, 14));
                text2.setWrapStyleWord(true);


                text2.setLineWrap(true);


		bt1 = new JButton("Find");
		panel1.add(bt1);
                
		Insets insets = panel1.getInsets();
 		Dimension size = bt1.getPreferredSize();
		bt1.setBounds(100 + insets.left, 250 + insets.top,
             	size.width +50, size.height+20);

		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(225, 250, 100, 45);
		quitButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent event) {
       		 System.exit(0);
  }
		});
		panel1.add(quitButton);
		

	bt1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         	String find=text1.getText();
			
			text2.setText(w.searchNode(find).meaning);
                        
		
        }

	});
        
        //clear button
        JButton bt5 = new JButton("Clear");
        bt5.setBounds(340, 250, 100, 45);
        panel1.add(bt5);
        bt5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            text1.setText("");
            text2.setText("");
       
    }
});
        }

	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setBackground(Color.gray);
		panel2.setLayout( null );

		JLabel label3 = new JLabel( "Enter Word:" );
		label3.setBounds( 20, 15, 150, 20 );
		panel2.add( label3);
                //textfiekd to enter  the word
		 text3 = new JTextField();
		text3.setBounds( 20, 40, 150, 20 );
		panel2.add( text3 );

		JLabel label4 = new JLabel( "Synonyms:" );
		label4.setBounds( 20, 70, 150, 20 );
		panel2.add( label4 );
		
		//text field to display synonyms
		text4 = new JTextField();
		text4.setBounds( 20, 100, 300, 100 );
		panel2.add( text4 );
                text4.setEditable(false);
                text4.setFont(new Font("Calibri", Font.BOLD, 15));
                 

		bt2 = new JButton("Synonyms");
		panel2.add(bt2);
		Insets insets = panel2.getInsets();
 		Dimension size = bt2.getPreferredSize();
		bt2.setBounds(90 + insets.left, 250 + insets.top,
             	size.width +40, size.height+20);
                
                //adding actions 
                bt2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
         	String find=text3.getText();
			
		text4.setText(w.similarWords(find).similar.toString());
		
        }

	});
                //quit button
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(235, 250, 100, 45);
		quitButton.addActionListener(new ActionListener() {
                    @Override
    		public void actionPerformed(ActionEvent event) {
       		 System.exit(0);
  }
		});
		panel2.add(quitButton);
                
                //clear button for panel2
                JButton bt6 = new JButton("Clear");
                bt6.setBounds(350, 250, 100, 45);
                panel2.add(bt6);
                bt6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                text3.setText("");
                text4.setText("");
        
    }
});
		
	
		
	}
        //third tab
	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout( null );
		panel3.setBackground(Color.gray);
		JLabel label5 = new JLabel( "Enter Word:" );
		label5.setBounds( 20, 15, 150, 20 );
		panel3.add( label5 );
                //text field to enter the word
		text5 = new JTextField();
		text5.setBounds( 20, 40, 150, 20 );
		panel3.add( text5 );

		JLabel label6 = new JLabel( "Description:" );
		label6.setBounds( 20, 70, 150, 20 );
		panel3.add( label6 );

                //text area to enter the description
		text6 = new JTextArea();
		text6.setBounds( 20, 90, 340, 70);
		panel3.add( text6 );
                text6.setWrapStyleWord(true);
                text6.setLineWrap(true);
                
                JLabel label = new JLabel( "Similar Words :(if there is no similar words, type no similar words)" );
		label.setBounds( 20, 180, 420, 20 );
		panel3.add( label );
                //add similar words
                text = new JTextField();
		text.setBounds( 20, 200, 340, 70 );
		panel3.add( text);

                //insert button
		bt3 = new JButton("Insert");
		panel3.add(bt3);
		Insets insets = panel3.getInsets();
 		Dimension size = bt3.getPreferredSize();
		bt3.setBounds(80 + insets.left, 300 + insets.top,
             	size.width +50, size.height+20);
                
                bt3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
         	String word=text5.getText();
                String mean=text6.getText();
                String similar=text.getText();
			
                w.insertNode(word,mean,similar);
                      
                                  
                JOptionPane.showMessageDialog (null, "You have successfully inserted a word.", "Insertion",JOptionPane.INFORMATION_MESSAGE);
		
        }

	});
                //quit button
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(210, 300, 100, 45);
		quitButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent event) {
       		 System.exit(0);
  }
		});
		panel3.add(quitButton);

                //clear button
		JButton bt7 = new JButton("Clear");
                bt7.setBounds(320, 300, 100, 45);
                panel3.add(bt7);
                bt7.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                text5.setText("");
                text6.setText("");
		text.setText("");
        
    }
});
		
	}
        //fourth tab
	public void createPage4()
	{
		panel4 = new JPanel();
		panel4.setLayout( null );
		panel4.setBackground(Color.gray);
		
		JLabel label7 = new JLabel( "Enter Word:" );
		label7.setBounds( 180, 30, 120, 20 );
		panel4.add( label7 );
                //text field to enter word
		text7 = new JTextField();
		text7.setBounds( 140, 70, 200, 40 );
		panel4.add( text7 );

		//delete button
		bt4 = new JButton("Delete");
		panel4.add(bt4);
		Insets insets = panel4.getInsets();
 		Dimension size = bt4.getPreferredSize();
		bt4.setBounds(120 + insets.left, 250 + insets.top,
             	size.width +50, size.height+20);
                
                bt4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
         	String word=text7.getText();
                
		//dialog box	
                w.deleteNode(w.searchNode(word));
                JOptionPane.showMessageDialog (null, "You have deleted a word.", "Delete",JOptionPane.WARNING_MESSAGE);

		
        }

	});
                //quit button
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(250, 250, 110, 45);
		quitButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent event) {
       		 System.exit(0);
                 }
		});
		panel4.add(quitButton);
		
	}
       
    // Main method of gui
	public static void main( String args[] ) throws FileNotFoundException
	{
		// Create an instance of the test application
		Dictionary mainFrame	= new Dictionary();
		mainFrame.setVisible( true );
		
			BST creator = new BST();
			w = creator.buildTree();
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//end of the gui


//node class 
class Node {
    //declare variables
    Node parent;
    Node leftChild;
    Node rightChild;
    
 
    String word;
    public String meaning;
    java.util.List<String> similar=new ArrayList<>();
   
    // node constructor
    public Node(String word,String meaning,String similar){
	this.word = word;
        this.meaning=meaning;
        this.similar.add(similar);
       	leftChild = null;
	rightChild = null;
	}
    //method to get right node 
    public Node getRightChild() {
        return rightChild;
    }
    //method to get left node
    public Node getLeftChild() {
        return leftChild;
    }
    //method to get word from a node
    public String getKey() {
        return word;
    }
   //method to set left child of a node
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
    //method to set word 
    public void setKey(String key) {
        this.word= key;
    }
    //method to set meaning 
    public void setMean(String meaning){
        this.meaning=meaning;
    }
    //method to get meaning 
    public String getMeaning(){
        return this.meaning;
    }
    //method to set similar words
    public void setSimilar(java.util.List<String> s){
        this.similar=s;
    }
    //method to get similar words
    public void getSimilar(){
        for (String n:similar){
            System.out.print(n);
        }
        
    }
    //method to set right child node 
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    //method to get parent node
   public Node getParent() {
        return parent;
    }
   //method to set parent node
    public void setParent(Node parent) {
        this.parent = parent;
    }

    }

//class to create binary search tree
class BST{
//variable declaration 
    Node root;
    Object word;
    String meaning;
    private  java.util.List<String> similar=new ArrayList<>();
  //constructor of binary search tree  
public BST(){
	this.root = null;
}

//this method search a word in input file
public Node searchNode(String key) {
        String data=key.toLowerCase();
        Node temp = this.root;
       //compare node value using while loop
        while(!temp.getKey().equals(data)) {
            if(data.compareTo(temp.getKey()) <= 0) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
            
            if (temp==null){
                Node nullnode = new Node("", "Word does not exist", null);
                return nullnode;
            }
        }
                   
            return temp;
          
}
//insertion of a  node
public void insertNode(String word,String meaning,String similar){
//first create a node
Node node = new Node(word,meaning,similar);
node.setLeftChild(null);
node.setRightChild(null);

if (this.root == null){
	this.root =node;
}
else {

	Node parentNode = null;
	Node temp =this.root;

	while(temp!=null){
		parentNode =temp;
		int value = node.getKey().compareTo(temp.getKey());
		if (value<=0){
			temp= temp.getLeftChild();
		}
		else {
			temp = temp.getRightChild();
		}
	}

//set the new node's parent as parentNode object
node.setParent(parentNode);
if (node.getKey().compareTo(parentNode.getKey()) <= 0) {
                parentNode.setLeftChild(node);
            } else {
                parentNode.setRightChild(node);
            }
        }
    }


// this is a private method that is useful in finding the successor of a node passed to the method
    private Node helpFindSuccessor(Node n) {
        if(n == null) {
            return null;
        }
        while(n.getLeftChild() != null) {
            n = n.getLeftChild();
        }
        return n;
    }

    // this method is used to find the successor node of the node with the given input key
    public Node getSuccessor(String key) {
        
        Node n = searchNode(key);
        if(n == null) {
            return null;
        }
        if(n.getRightChild() != null) {
            return helpFindSuccessor(n.getRightChild());
        }
        Node successorNode = n.getParent();
        while(successorNode != null && successorNode.getLeftChild() != n) {
            n= successorNode;
            successorNode = successorNode.getParent();
        }
        return successorNode;
    }
    
    //delete node
    public void deleteNode(Node node) {
        // check if the node to be deleted is a valid reference, if its an invalid reference then we don't need to do anything at all
        if(node == null) {
            return;
        }

        // Case-1 : If the node to be deleted has no child references at all
        if(node.getLeftChild() == null && node.getRightChild() == null) {
            Node nodeParent = node.getParent();
            // if the node to be deleted is the root node
            if(nodeParent == null) {
                this.root = null;
            } else if (nodeParent.getLeftChild() == node) {
                nodeParent.setLeftChild(null );
            } else {
                nodeParent.setRightChild(null);
            }
            node.setParent(null);
        }

        // Case-2 : If the node to be deleted has one node as its child node
        if(node.getLeftChild() != null && node.getRightChild() == null) {
            Node parentNode = node.getParent();
            // if the node to be deleted is the root node and it has a left child then make the left child of the root node as root
            if(parentNode == null) {
                this.root = node.getLeftChild();
            } else {
                // if the node to be deleted is the left child of its parent node
                if(parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(node.getLeftChild());
                } else {
                    parentNode.setRightChild(node.getLeftChild());
                }
            }
            node.getLeftChild().setParent(parentNode);
            node.setParent(null);
            node.setLeftChild(null);
        }

        if(node.getLeftChild() == null && node.getRightChild() != null) {
            Node nodeParent = node.getParent();
            // if the node to be deleted is the root node and it has a right child
            if(nodeParent == null) {
                this.root = node.getRightChild();
            } else {
                // if the node to be deleted is the left child of its parent node
                if(nodeParent.getLeftChild() == node) {
                    nodeParent.setLeftChild(node.getRightChild());
                } else {
                    nodeParent.setRightChild(node.getRightChild());
                }
            }
            node.getRightChild().setParent(nodeParent);
            node.setParent(null);
            node.setRightChild(null);
        }

        // Case-3 : if the node to be deleted has both a left and a right child
        if(node.getLeftChild() != null && node.getRightChild() != null) {
            Node parentNode = node.getParent();

            // first we get the successor of the node in the Binary Search Tree
            Node successorNode = getSuccessor(node.getKey());
             //Node successorNodemeaning = getSuccessor(node.getMeaning());
            Node successorParent = successorNode.getParent();
            Node successorRightChild = successorNode.getRightChild();

            // if the successor node doesn't have any right child, it obviously doesn't have any left child as its the successor node
            if(successorRightChild == null) {
                node.setKey(successorNode.getKey());
                node.setMean(successorNode.meaning);
                node.setSimilar(successorNode.similar);
               // node.setMeaning(successorNodemeaning.getMeaning());
                        
                if(successorParent.getRightChild() == successorNode) {
                    successorParent.setRightChild(null);
                } else {
                    successorParent.setLeftChild(null);
                }
                return;
            } else {
                node.setKey(successorNode.getKey());
                node.setMean(successorNode.meaning);
                node.setSimilar(successorNode.similar);
                if(successorParent.getRightChild() == successorNode) {
                    successorParent.setRightChild(successorRightChild);
                } else {
                    successorParent.setLeftChild(successorRightChild);
                }
            }
            successorRightChild.setParent(successorParent);
            successorNode.setParent(null);
            successorNode.setLeftChild(null);
            successorNode.setRightChild(null);
        }
    }
    
  
    
    //search similar words
   public Node similarWords(String word){
       
        Node temp = searchNode(word);
        
      return temp;
               }

    //method to build the tree
    public BST buildTree() throws FileNotFoundException{
       BST b = new BST();
       
                        //get input file
			Scanner s = new Scanner(new File("C:\\Users\\admin\\Desktop\\Words.txt")); //.useDelimiter(",\\s*");
                      
                        //build tree
                        while(s.hasNextLine()){
			String str=s.nextLine();
                        StringTokenizer st = new StringTokenizer(str,":");
                        
                        
                        while (st.hasMoreElements()) {
                                    
                                    String str1=(String)st.nextElement();
                                   
                                    String str2=(String)st.nextElement();
                                   
                                    String str3=(String)st.nextElement();
                                  //build tre by inserting word from input file
                                    b.insertNode(str1.toLowerCase(),str2.toLowerCase(),str3.toLowerCase());
                                    
                                       
                                    
		}
                        
                        }
			s.close();
                        
       
     return b;
      
    }
  
         
         
}