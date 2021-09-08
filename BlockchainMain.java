import java.util.*;

public class BlockchainMain {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String args[]){
        Block b = new Block(0, null, "My first block"); // Genesis block

        b.mineBlock(difficulty);
        blockchain.add(b);
        System.out.println(b.toString());
        System.out.println("Current block valid: " + validateBlock(b, null));

        Block b2 = new Block(1, b.curHash, "My second block");
        b2.mineBlock(difficulty);
        blockchain.add(b2);
        //b2.data = "My third block"; // test validation by changing data attribute after block has already been generated
        System.out.println(b2.toString());
        System.out.println("Current block valid: " + validateBlock(b2, b));
    }

    public static boolean validateBlock(Block newBlock, Block prevBlock){
        if (prevBlock == null) { // first block

            // validate last index
            if(newBlock.index != 0) {
                return false;
            }

            // validate value of prevHash
            if (newBlock.prevHash != null) {
                return false;
            }

            // validate hash of previous block
            if (newBlock.curHash == null || !newBlock.calculateHash().equals(newBlock.curHash)) {
                return false;
            }

            return true;

        } else {
            if (newBlock != null) { // rest of the blocks

                // validate next index is one greater than previous
                if (prevBlock.index + 1 != newBlock.index) {
                    return false;
                }

                // validate prevHash is the same for last block and new block
                if (newBlock.prevHash == null || !newBlock.prevHash.equals(prevBlock.curHash)){
                    return false;
                }

                // validate the current hash was calculated correctly
                if (newBlock.curHash == null || !newBlock.calculateHash().equals(newBlock.curHash)){
                    return false;
                }

                return true;
            }

            return false;
        }

        
    }
}
