

// TODO: Auto-generated Javadoc
/**
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Incomplete
 * Last update: 09/13/14
 * Submitted:  09/15/14
 * Comment:.
 *
 * @param <T> the generic type
 * @author: Yusef(Joe) Cardona
 * @version: 2014.09.09
 */


public class ListArrayBasedPlus<T> extends ListArrayBased<T>
{
    
    /**
     * Instantiates a new list array based plus.
     */
    public ListArrayBasedPlus()
    {
        super();
    }
    
    /* (non-Javadoc)
     * @see dsaProject.ListArrayBased#add(int, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
	public void add(int index, T item)
    {
        try
        {
            super.add(index, item);//tries to execute super add method
        }
        catch(ListException e)//if the array is already at full capacity it will be resized to be larger
            //and take in more items
        {
            //increases the size of the maximum list
            Object []newArray = new Object[items.length + (items.length /2)];
            for(int i = 0; i < this.numItems; i++)
            {
                newArray[i] = items[i];
            }//end for
            items = (T[]) newArray;
            super.add(index, item);
        }//end catch
        catch(ListIndexOutOfBoundsException e)
        {
            System.out.println("Error INdex out of bounds :" + index + "\nsize of array"+ this.size());
        }
    }//end add
    
    /**
     * Reverse.
     */
    @SuppressWarnings("unchecked")
	public void reverse()
    {
        int p = 0;
        Object []newArray = new Object[items.length];
        for(int i = this.numItems - 1; i >= 0; i-- )
        {
            Object n = items[i];
            newArray[p] = n;
            p++;
        }//end for
        items = (T[]) newArray;
        System.out.println("List Reversed");
    }//end reverse

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String array;
        for(int i = 0; i < super.size(); i++)
        {
            sb.append(items[i] + " ");
        }
        array = sb.toString();
        return array;
    }//end toString
    //exits program
    /**
     * Exit.
     */
    public static void exit()
    {
        System.exit(0);
    }

}
