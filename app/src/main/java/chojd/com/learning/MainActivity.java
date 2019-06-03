package chojd.com.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.com.ofashion.cleanarchitecture.component.DaggerDashboardComponent;
import cn.com.ofashion.cleanarchitecture.di.DaggerHTTPComponent;
import cn.com.ofashion.cleanarchitecture.model.Dashboard;
import cn.com.ofashion.cleanarchitecture.model.Student;
import cn.com.ofashion.cleanarchitecture.model.Teacher;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardPresenter;
import cn.com.ofashion.cleanarchitecture.presenter.DashboardView;
import cn.com.ofashion.cleanarchitecture.repository.DashboardRepository;
import cn.com.ofashion.cleanarchitecture.usecase.DashboardUseCase;

public class MainActivity extends AppCompatActivity implements DashboardView {

    private DashboardPresenter presenter;

    private TextView centerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = DaggerDashboardComponent.builder().dashboardView(this).baseUrl("http://localhost/").build().presenter();

        this.centerTV = findViewById(R.id.tv_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.loadView("abc","cdd");
    }

    // DashboardView interface
    @Override
    public void loadDashboard(Dashboard dashboard) {
        this.centerTV.setText("abcccc");
//        this.centerTV.setText(dashboard.teacher().name());
    }
}