//package it.academy.service;
//
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@ContextConfiguration(classes = AppConfig.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//public class PromoServiceTest {

//    @Autowired
//    PromoService promoService;
//
//    @org.junit.Test
//    public void findAllPromo() {
//        //Given
//        PromoDaoImpl promoDaoMock = Mockito.mock(PromoDaoImpl.class);
//        Promo promo = new Promo();
//        promo.setDescription("Promo1");
//        Mockito
//                .when(promoDaoMock.findAllPromo())
//                .thenReturn(List.of(promo, promo));
//        promoService.setPromoDao(promoDaoMock);
//
//        //When
//        final List<Promo> allPromo = promoService.findAllPromo();
//
//        //Then
//        assertNotNull(allPromo);
//        assertEquals(2, allPromo.size());
//        assertEquals("Promo1", allPromo.get(0).getDescription());
//        assertNull(allPromo.get(1).getPromoId());
//    }
