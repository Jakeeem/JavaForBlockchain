import java.util.*;

public class BlockchainMain {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String args[]){
        Block b = new Block(0, null, "My first block"); // Genesis block

        b.mineBlock(difficulty);
        blockchain.add(b);
        System.out.println(b.toString());

        Block b2 = new Block(1, b.curHash, "My second block");
        b2.mineBlock(difficulty);
        blockchain.add(b2);
        System.out.println(b2.toString());
    }
}
