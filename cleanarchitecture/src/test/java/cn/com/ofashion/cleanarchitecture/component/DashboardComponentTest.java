package cn.com.ofashion.cleanarchitecture.component;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.com.ofashion.cleanarchitecture.presenter.DashboardPresenter;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardView;

import static org.junit.Assert.*;

public class DashboardComponentTest {

    @Mock
    DashboardView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void presenter() {
        DashboardComponent dashboardComponent = DaggerDashboardComponent.builder().baseUrl("http://localhost/").dashboardView(this.view).build();
        Truth.assertThat(dashboardComponent).isNotNull();
        DashboardPresenter presenter = dashboardComponent.presenter();
        Truth.assertThat(presenter).isNotNull();
    }
}