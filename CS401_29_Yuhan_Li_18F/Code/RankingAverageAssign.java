import java.util.*;

class RankingAverageAssign implements Comparator<grade>
{
    public int compare(grade g1, grade g2){
        int AveResult = (int) (g2.getAverageAssignGrade() - g1.getAverageAssignGrade());
        if(AveResult != 0)
        {
            return AveResult;
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