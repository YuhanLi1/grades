import java.util.*;

class RankingLastname implements Comparator<grade>
{
    public int compare(grade g1, grade g2)
    {
        int CNResult = g1.getCourse_num().compareTo(g2.getCourse_num());
        if(CNResult != 0) 
        {
            return CNResult;
        }
        else
        {
            int SiteResult =  g1.getSite() - g2.getSite();
            if(SiteResult != 0)
            {
                return SiteResult;
            }
            else
            {
                return (int) (g1.getlastN().compareTo(g2.getlastN()));
            } 

        }

    }
}