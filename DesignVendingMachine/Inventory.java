package DesignVendingMachine;

public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int itemCount){
        inventory=new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory(){
        int startCode= 101;
        for(int i=0;i<inventory.length;i++){
            ItemShelf space=new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i]=space;
            startCode++;
        }
    }

    public void addItem(Item item,int codeNumber) throws Exception{
        for(ItemShelf shelf:inventory){
            if(shelf.getCode()==codeNumber)
            {
                if(shelf.isSoldOut()){
                    shelf.item=item;
                    shelf.setSoldOut(false);
                }
                else{
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception{
        for(ItemShelf shelf:inventory){
            if(shelf.getCode()==codeNumber){
                if(shelf.isSoldOut())
                {
                    throw new Exception("item already sold out");
                }else{
                    return shelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
