package trade;


import static org.junit.jupiter.api.Assertions.*;

import ds.MySqlDataSource;
import ds.OracleDataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;

@ExtendWith(MockitoExtension.class)
public class daoTest {


    @Mock
    RegionalDao regionalDao;


    RegionalDaoManager regionalDaoManager = new RegionalDaoManager();

    LondonDao londonDao = new LondonDao();

    NewyorkDao newyorkDao = new NewyorkDao();

    TokyoDao tokyoDao = new TokyoDao();



    @Test
    public void getTradeDetailsShouldBeTrue() {
        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenReturn(new TradeDetails());

        TradeDetails tradeDetails = regionalDao.getTradeDetails(12345678);

        assertNotNull(tradeDetails);
    }



    @Test
    public void getTradeDetailsShouldThrowException() {
        Mockito.when(regionalDao.getTradeDetails(Mockito.any(long.class))).thenThrow(RuntimeException.class);

        Executable e = () -> regionalDao.getTradeDetails(12345678);

        assertThrows(RuntimeException.class,e);
    }




    @Test
    public void regionalDaoMangerShouldBeTrue() {

        DataSource dataSource = regionalDaoManager.getRegionalDao(Region.TOKYO).getDataSource();
        assertNotNull(dataSource);

         dataSource = regionalDaoManager.getRegionalDao(Region.LONDON).getDataSource();
        assertNotNull(dataSource);

        dataSource = regionalDaoManager.getRegionalDao(Region.NEWYORK).getDataSource();
        assertNotNull(dataSource);


    }



    @Test
    public void regionalDaoMangerShouldThrowException() {

        Executable e  = () -> regionalDaoManager.getRegionalDao(Region.valueOf("random string"));

        assertThrows(IllegalArgumentException.class,e);

    }




}
