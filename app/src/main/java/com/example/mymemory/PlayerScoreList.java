package com.example.mymemory;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.io.*;
import java.util.*;
public class PlayerScoreList {
    private static final PlayerScoreList ourInstance = new PlayerScoreList();
    private PlayerScoreList() { }
    public static PlayerScoreList getInstance() {
        return ourInstance;
    }
    private List<PlayerScore> players;
    //initial List. It's first used to add a template list for testing code.
    public void add()
    {
        players = new ArrayList<PlayerScore>();
        /*
        players.add(new PlayerScore("Nhan", "1", "6","23"));
        players.add(new PlayerScore("Nhan", "2", "7","33"));
        players.add(new PlayerScore("Nhan", "3", "8","43"));
        players.add(new PlayerScore("Nhan", "4", "9","53"));
        players.add(new PlayerScore("Nhan", "5", "0","53"));
        */
        //Log.d("score", players.[0]);
    }
    //add Player from file txt

    public void add(String Name, String ID, String Card, String Numb)
    {
        players.add(new PlayerScore(Name,ID,Card,Numb));
    }
    //use to create new player
    public void add(String PName)
    {
        //make sure each player have the different ID, to identify if the player have the same name.
        for(int i=1; i < players.size()+1;++i)
        {
            if (Integer.toString(i).equals(PlayerScoreList.getInstance().players.get((i-1)).getID()))
            {
            }
            else
            {
                players.add(new PlayerScore(PName,Integer.toString(i),"0","0"));
                return;
            }
        }
        players.add(new PlayerScore(PName,Integer.toString((players.size()+1)),"0","0"));
    }
    //save the information of the player who played last time
    public void saveLastPlayer(Context context, int n)
    {

        String fileName = "LastPlayer.txt";
        File rewrite = new File(fileName); //write the file again to make sure only 1 player played last time
        try
        {
            FileOutputStream outputStream ;//= new FileOutputStream(rewrite,false);
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                outputStream.write(Integer.toString(n).getBytes());
                //PlayerScoreList.getInstance().players.get(n).getID()
            outputStream.close();
            Toast.makeText(context, "Hello " + PlayerScoreList.getInstance().players.get(n).getName(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //find who played last time
    public String readLastPlayer(Context context)
    {
        String getLP="0";
        try
        {
            FileInputStream in = context.openFileInput("LastPlayer.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while((line= br.readLine())!= null)  {
                buffer.append(line).append("\n");
            }
            getLP=buffer.toString();
            in.close();
            Log.d("readdd-data",buffer.toString());
            Log.d("realll-data",getLP);
            String indexP= getLP.toString().trim();
            Log.d("realll-dataindex:",indexP);
            Log.d("dfsdfdsf",Integer.toString(MainActivity.stringToint(indexP)));
            //Log.d("testparse",(String)Integer.toString(Integer.parseInt(getLP)));
            return getLP;
            //Toast.makeText(context, "Hello " + PlayerScoreList.getInstance().players.get(Integer.parseInt(getLP)).getName(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
        }
        return getLP;
    }
    //save data to txt file
    public void saveDataDefault(Context context, String noti)
    {
        String fileName = "ScoreList.txt";
        File rewrite = new File(fileName);
        try
        {
            FileOutputStream outputStream ;//= new FileOutputStream(rewrite,false);
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for (int i=0;i<players.size();++i)
            {
                outputStream.write((PlayerScoreList.getInstance().players.get(i).getName() + " " + PlayerScoreList.getInstance().players.get(i).getID() + " " + PlayerScoreList.getInstance().players.get(i).getScoreC() + " " + PlayerScoreList.getInstance().players.get(i).getScoreN() + "\n").getBytes());
            }
            outputStream.close();
            if(noti!=null) {Toast.makeText(context, noti, Toast.LENGTH_SHORT).show();}
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void readData(Context context)
    {
        try
        {
            FileInputStream in = context.openFileInput("ScoreList.txt");
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while((line= br.readLine())!= null)
            {
                String[] info = line.split(" ");
                if (info.length==4)
                {
                    PlayerScoreList.getInstance().add(info[0],info[1],info[2],info[3]);
                }
            }
            Log.d("read-data:",buffer.toString());
            in.close();
        } catch (Exception e)
        {
        }
    }
    //save after played game
    public void saveTimeScore(long playedTime, int index)
    {
        String Time;
        long secs = (playedTime/1000);
        long mins= secs/60;
        secs = secs %60;
        long milliseconds = (playedTime%1000);
        Time = String.format("%02d",mins)+":" + String.format("%02d",secs) + ":" + String.format("%02d",milliseconds);
        if (Time.compareTo(PlayerScoreList.getInstance().players.get(index).getScoreC())<0 && MainActivity.stringToint(PlayerScoreList.getInstance().players.get(index).getScoreC())!=0)
        {
            PlayerScoreList.getInstance().players.get(index).setCard(Time);
        }
    }
    public void saveNumScore(String Numb, int index)
    {
        if(MainActivity.stringToint(Numb)>MainActivity.stringToint(PlayerScoreList.getInstance().players.get(index).getScoreN()))
        {
            PlayerScoreList.getInstance().players.get(index).setNumb(Numb);
        }
    }
    public void remove(int i)
    {
        players.remove(i);
    }
    public List<PlayerScore> getPlayerScoreList(){return this.players;}
    public PlayerScore getPlayerScore(int value){return this.players.get(value);}

}
