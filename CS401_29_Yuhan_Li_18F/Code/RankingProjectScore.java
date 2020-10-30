import java.util.*;

class RankingProjectScore implements Comparator<grade>
{
    public int compare(grade g1, grade g2){
        int ProResult = g2.getProGrade() - g1.getProGrade();
        if(ProResult != 0)
        {
            return ProResult;
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