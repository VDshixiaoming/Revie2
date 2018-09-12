package com.application.sxm.revie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.application.sxm.revie.R;
import com.application.sxm.revie.model.MovieItemBean;
import com.application.sxm.revie.model.MovieListModel;
import com.application.sxm.revie.service.DoubanApiProvider;
import com.application.sxm.revie.viewholder.HomeViewBinder;


import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 首页fragment
 * Created by shixiaoming on 18/9/11.
 */
public class HomeFragment extends BaseFragment{

    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    private MultiTypeAdapter adapter;
    @Override
    public int getContentViewRes() {
        return R.layout.revie_fragment_home;
    }

    @Override
    public void initView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MultiTypeAdapter();
        adapter.register(MovieItemBean.class, new HomeViewBinder());
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void initData() {


        DoubanApiProvider.getInstance(getContext()).getHotMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieListModel>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieListModel movieListModel) {
                        onLoadSuccess(movieListModel);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                });
    }

    private void onLoadSuccess(MovieListModel movieListModel) {
        if (movieListModel != null && movieListModel.getSubjects() != null && !movieListModel.getSubjects().isEmpty()) {
            adapter.setItems(movieListModel.getSubjects());
            adapter.notifyDataSetChanged();
        }
    }
}
